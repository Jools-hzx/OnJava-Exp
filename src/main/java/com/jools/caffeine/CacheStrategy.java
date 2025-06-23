package com.jools.caffeine;

import com.github.benmanes.caffeine.cache.AsyncLoadingCache;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/1/7 12:18
 * @description: TODO
 */
public class CacheStrategy {

    //此策略与上一个策略的作用相同，但异步执行操作并返回一个包含实际值的`CompletableFuture`：
    @Test
    public void testAsynchronous() {
        AsyncLoadingCache<String, DataObject> cache = Caffeine.newBuilder()
                .maximumSize(100)
                .expireAfterWrite(1, TimeUnit.MINUTES)
                .buildAsync(k -> DataObject.get("Data for " + k));

        //GET 方法
        String key = "A";
        cache.get(key).thenAccept(dataObject -> {
            Assert.assertNotNull(dataObject);
            Assert.assertEquals("Data for " + key, dataObject.getData());
        });

        //GETALL 方法, 返回 CompletableFuture 对象
        cache.getAll(Arrays.asList("A", "B", "C")).thenAccept(
                dataObjectMap -> Assert.assertEquals(3, dataObjectMap.size())
        );
    }

    @Test
    public void testSynchronous() {
        //这种加载缓存的方法接受一个函数，该函数用于初始化值，类似于手动策略的“获取”方法。让我们看看如何使用它。
        LoadingCache<String, DataObject> cache = Caffeine.newBuilder()
                .maximumSize(100)
                .expireAfterWrite(1, TimeUnit.MINUTES)
                .build(k -> DataObject.get("Data for synchronous " + k));

        String key = "A";
        DataObject dataObject = cache.get(key);
        Assert.assertNotNull(dataObject);
        Assert.assertEquals("Data for synchronous " + key, dataObject.getData());

        //getAll
        Map<String, DataObject> dataObjectMap = cache.getAll(Arrays.asList("A", "b", "C"));
        Assert.assertEquals(3, dataObjectMap.size());

        for (String k : dataObjectMap.keySet()) {
            System.out.println(k + " " + dataObjectMap.get(k).getData());
        }
        /*
         输出:
         A Data for synchronous A
         b Data for synchronous b
         C Data for synchronous C
         */
    }


    @Test
    public void testManual() {
        Cache<String, DataObject> cache = Caffeine.newBuilder()
                .expireAfterWrite(1, TimeUnit.MINUTES)
                .maximumSize(100)
                .build();


        //从 Cache 获取数据
        String key = "A";
        DataObject dataObject = cache.getIfPresent(key);
        Assert.assertNull(dataObject);      // Test pass

        dataObject = new DataObject("VALUE");
        cache.put(key, dataObject);
        DataObject ans = cache.getIfPresent(key);
        Assert.assertNotNull(ans);          // Test pass

        //如果该键值不存在，则构建插入缓存
        // A 为键值的记录存在，不为空
        dataObject = cache.get(key, k -> DataObject.get("Data for A"));
        Assert.assertNotNull(dataObject);

        // A-1 为键值的记录不存在，插入 DataObject
        dataObject = cache.get(key + "-1", k -> DataObject.get("Data for A"));
        Assert.assertEquals("Data for A", dataObject.getData());

        //令缓存失效
        cache.invalidate(key);
        dataObject = cache.getIfPresent(key);
        Assert.assertNull(dataObject);
    }
}
