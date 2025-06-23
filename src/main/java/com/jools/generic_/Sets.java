package com.jools.generic_;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/18 20:20
 * @description: TODO
 */
public class Sets {

    // 求并集
    public static <T> Set<T> union(Set<T> a, Set<T> b) {
        HashSet<T> result = new HashSet<>(a);
        result.addAll(b);
        return result;
    }

    // 求交集
    public static <T> Set<T> intersection(Set<T> a, Set<T> b) {
        HashSet<T> result = new HashSet<>(a);
        result.retainAll(b);
        return result;
    }

    // 从超集中减去子集
    public static <T> Set<T> difference(Set<T> superSet, Set<T> subset) {
        Set<T> result = new HashSet<>(superSet);
        result.removeAll(subset);
        return result;
    }

    // 所有不在交集中的元素
    public static <T> Set<T> complement(Set<T> a, Set<T> b) {
        return difference(union(a, b), intersection(a, b));
    }
}
