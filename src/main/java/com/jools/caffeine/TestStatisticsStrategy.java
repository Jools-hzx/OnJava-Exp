package com.jools.caffeine;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/1/7 17:54
 * @description: TODO
 */
public class TestStatisticsStrategy {

    @Test
    public void testStatistics() {
//        LoadingCache<Object, DataObject> cache = Caffeine.newBuilder().maximumSize(100).recordStats()
//                .build(k -> DataObject.get("Data for " + k));
//
//        cache.get("A"); // 第一次获取无键值 A 构建插入
//        cache.get("A");
//
//        //命中次数，第二次
//        Assert.assertEquals(1, cache.stats().hitCount());
//        //未命中次数；首次
//        Assert.assertEquals(1, cache.stats().missCount());
//        //load 次数 1 次
//        Assert.assertEquals(1, cache.stats().loadCount());

        int[] a1 = new int[]{1, 2, 3};
        int[] newArr = Arrays.copyOf(a1, a1.length);
        System.out.println(Arrays.toString(newArr));
    }

}
