package com.jools.caffeine;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/1/7 17:39
 * @description: TODO
 */
public class TestRefreshStrategy {

    @Test
    public void testRefreshStrategy() throws InterruptedException {

        LoadingCache<Object, DataObject> refreshCache = Caffeine.newBuilder()
                .refreshAfterWrite(1, TimeUnit.SECONDS)
                .build(k -> DataObject.get("Data for " + k));

        String key = "testKey";
        DataObject dataObject = refreshCache.get(key);
        Assert.assertNotNull(dataObject);
        Assert.assertEquals("Data for testKey", dataObject.getData());

        //休眠 1s, 触发缓存刷新
        TimeUnit.SECONDS.sleep(1);

        //再次获取相同的 key, 验证刷新后值不为空; reload 插入旧值
        dataObject = refreshCache.get(key);
        Assert.assertEquals("Data for testKey", dataObject.getData());
    }
}
