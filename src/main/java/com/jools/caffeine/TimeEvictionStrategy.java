package com.jools.caffeine;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.Expiry;
import com.github.benmanes.caffeine.cache.LoadingCache;
import org.checkerframework.checker.units.qual.A;
import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/1/7 17:15
 * @description: TODO
 */
public class TimeEvictionStrategy {

    @Test
    public void testCustomPolicy() {
        LoadingCache<String, DataObject> cache = Caffeine
                .newBuilder()
                .expireAfter(
                        new Expiry<String, DataObject>() {
                            @Override
                            public long expireAfterCreate(String key, DataObject value, long currentTime) {
                                return value.getData().length() * 1000;
                            }

                            @Override
                            public long expireAfterUpdate(String key, DataObject value, long currentTime, long currentDuration) {
                                return currentDuration;
                            }

                            @Override
                            public long expireAfterRead(String key, DataObject value, long currentTime, long currentDuration) {
                                return currentDuration;
                            }
                        })
                .build(k -> DataObject.get("Data for " + k));

    }


    @Test
    public void testExpireAfterAccess() {
        LoadingCache<String, DataObject> cache = Caffeine.newBuilder()
                .expireAfterAccess(5, TimeUnit.SECONDS)
                .build(k -> DataObject.get("Data for " + k));

        DataObject dataObject = cache.get("A");
        System.out.println(dataObject.getData());
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        cache.cleanUp();    //Access after 6+s, remove key "A"
        Assert.assertEquals(0, cache.estimatedSize());
    }


    @Test
    public void testExpireAfterWrite() throws InterruptedException {
        LoadingCache<Object, DataObject> cache = Caffeine
                .newBuilder()
                .expireAfterWrite(5, TimeUnit.SECONDS)
                .weakKeys()
                .weakValues()
                .build(k -> DataObject.get("Data for " + k));

        DataObject dataObject = cache.get("A");
        System.out.println(dataObject.getData());

        //Access after 5+s, remove key "A"
        Thread.sleep(5001);

        cache.cleanUp();    //Async remove A

        //write new value, key = "B"
        cache.get("B");

        Assert.assertEquals(1, cache.estimatedSize());
    }

}
