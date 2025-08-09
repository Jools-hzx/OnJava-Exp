package com.jools.designpattern.singleton;

/**
 * @author Jools He
 * @date 2025/7/25 22:31
 * @description: TODO
 */
public class DoubleLockLazySingleton {

    private volatile static DoubleLockLazySingleton instance;

    private DoubleLockLazySingleton() {}

    public static DoubleLockLazySingleton getInstance() {
        if(instance == null) {
            synchronized (DoubleLockLazySingleton.class) {
                if(instance == null) {
                    instance = new DoubleLockLazySingleton();
                }
            }
        }
        return instance;
    }
}
