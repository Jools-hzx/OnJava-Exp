package com.jools.designpattern.singleton;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/1/30 21:24
 * @description: TODO
 */
public class DoubleLocksSingleton {

    private volatile static DoubleLocksSingleton singleInstance;

    private DoubleLocksSingleton() {
    }

    public static DoubleLocksSingleton getInstance() {
        // 判断对象是否已经实例化了
        if (singleInstance == null) {
            synchronized (DoubleLocksSingleton.class) {
                if (singleInstance == null) {
                    singleInstance = new DoubleLocksSingleton();
                }
            }
        }
        return singleInstance;
    }
}
