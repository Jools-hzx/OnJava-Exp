package com.jools.designpattern.singleton;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/1/8 20:38
 * @description: TODO
 */
public class StaticInnerClassSingleton {
    private StaticInnerClassSingleton() {
    }

    private static class SingletonHolder {
        private static final StaticInnerClassSingleton INSTANCE = new StaticInnerClassSingleton();
    }

    public static StaticInnerClassSingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
