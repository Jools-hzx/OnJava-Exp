package com.jools.designpattern.singleton;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/1/8 20:34
 * @description: 懒汉式单例
 */
public class LazySingletonObject {
    private static LazySingletonObject singleton;

    private LazySingletonObject() {
    }

    public static LazySingletonObject getSingleton() {
        if (singleton == null) {
            singleton = new LazySingletonObject();
        }
        return singleton;
    }
}
