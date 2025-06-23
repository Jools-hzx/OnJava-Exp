package com.jools.caffeine;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/1/7 17:33
 * @description: TODO
 */
public class TestReferenceBasedStrategy {


    @Test
    public void testReferenceBasedStrategy() {
        LoadingCache<String, DataObject> cache = Caffeine.newBuilder()
                .expireAfterWrite(10, TimeUnit.SECONDS)
                .weakKeys()     // 如果没有任何强引用则会被回收
                .weakValues()
                .build(k -> DataObject.get("Data for " + k));

        cache = Caffeine.newBuilder()
                .expireAfterWrite(10, TimeUnit.SECONDS)
                .softValues()   // 根据 JVM 全局最少使用策略对象进行回收
                .build(k -> DataObject.get("Data for " + k));
    }
}
