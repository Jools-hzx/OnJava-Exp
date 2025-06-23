package com.jools.caffeine;

import com.github.benmanes.caffeine.cache.AsyncCache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import org.junit.Assert;
import org.junit.Test;

import javax.xml.crypto.Data;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/1/7 16:52
 * @description: TODO
 */
public class EvictionStrategy {

    @Test
    public void testWeigherFunctionForSizeBasedEviction() {

        LoadingCache<Object, DataObject> cache = Caffeine.newBuilder()
                .maximumWeight(10)
                .weigher((k, v) -> 5)
                .build(k -> DataObject.get("Data for " + k));

        Assert.assertEquals(0, cache.estimatedSize());

        cache.get("A");
        Assert.assertEquals(1, cache.estimatedSize());
        cache.get("A").getData().equals("Data for A");

        cache.get("B");
        Assert.assertEquals(2, cache.estimatedSize());
        cache.get("B").getData().equals("Data for B");

        cache.get("C");
        cache.cleanUp();

        Assert.assertEquals(2, cache.estimatedSize());
    }

    //当缓存的配置大小限制被超出时，就会发生逐出。
    @Test
    public void testSizeBasedEviction() {

        LoadingCache<Object, DataObject> cache = Caffeine
                .newBuilder()
                .maximumSize(1)
                .build(k -> DataObject.get("Data for " + k));

        //缓存为空
        Assert.assertEquals(0, cache.estimatedSize());

        //插入数据
        cache.get("A");
        Assert.assertEquals(1, cache.estimatedSize());  //获取当前缓存容量

        //插入数据，大于 cache 容量后自动请求首个缓存值 A
        cache.get("B");
        //在获取缓存大小之前调用cleanUp方法。这是因为缓存淘汰是异步执行的，而这个方法有助于等待淘汰的完成。
        cache.cleanUp();

        Assert.assertEquals(1, cache.estimatedSize());
    }
}
