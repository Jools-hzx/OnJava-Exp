package com.jools.generic_;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/21 16:32
 * @description: TODO
 */
public class UnboundedWildcard2 {

    static Map map1;
    static Map<?, ?> map2;
    static Map<String, ?> map3;

    static void assign1(Map map) {
        map1 = map;
    }

    // Map<?, ?> 中全部都是无界通配符的情况下，编译器看起来并不会将其和原始类型 Map 区分开来
    static void assign2(Map<?, ?> map) {
        map2 = map;
    }

    static void assign3(Map<String, ?> map) {
        map3 = map;
    }

    public static void main(String[] args) {
        assign1(new HashMap());
        assign2(new HashMap());
        assign3(new HashMap()); //Unchecked assignment: 'java.util.HashMap' to 'java.util.Map<java.lang.String,?>'

        // 编译器并不总是关系两者之间的, 比如 List 和 List<?> 的区别
        // 由于泛型参数会被擦除为其第一个边界类型，List<?> 会看起来等同于 List<Object>;
        // 细微区别: 1. List 持有任意 Object 类型的原生 List 2. List<?> 指的是 '持有某种具体类型' 的非原生 List
        assign1(new HashMap<>());
        assign2(new HashMap<>());
        assign3(new HashMap<>());
    }
}
