package com.jools.designpattern.singleton;

/**
 * @author Jools He
 * @date 2025/7/25 22:29
 * @description: TODO
 */
public class ConcurrentLazySingleton {

    private static ConcurrentLazySingleton instance;

    private ConcurrentLazySingleton() {
    }

    public static synchronized ConcurrentLazySingleton getInstance() {
        if (instance == null) {
            instance = new ConcurrentLazySingleton();
        }
        return instance;
    }
}
