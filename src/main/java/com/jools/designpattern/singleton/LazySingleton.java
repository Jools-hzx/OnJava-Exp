package com.jools.designpattern.singleton;

/**
 * @author Jools He
 * @date 2025/7/25 22:26
 * @description: TODO
 */
public class LazySingleton {

    private static LazySingleton instance;

    private LazySingleton() {}

    public static LazySingleton getInstance() {
        if(instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
