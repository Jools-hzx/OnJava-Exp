package com.jools.designpattern.flyweight.security;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jools He
 * @date 2025/7/29 21:32
 * @description: TODO
 */
public class FlyweightFactory {

    //构造懒汉式单例
    private static FlyweightFactory factory = new FlyweightFactory();

    private FlyweightFactory() {
    }

    public static FlyweightFactory getInstance() {
        return factory;
    }

    // 缓存多个 Flyweight 对象
    private Map<String, Flyweight> fs = new HashMap<>();

    // 获取 key 对应的享元对象否则创建
    public Flyweight getFlyweight(String key) {
        return fs.computeIfAbsent(key, k -> new AuthorizationFlyweight(k));
    }
}
