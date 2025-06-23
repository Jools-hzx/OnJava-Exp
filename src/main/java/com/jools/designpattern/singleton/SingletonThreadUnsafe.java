package com.jools.designpattern.singleton;

import lombok.Data;
import lombok.Getter;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/1/8 20:27
 * @description: TODO
 */
public class SingletonThreadUnsafe {

    private static SingletonThreadUnsafe singleton = new SingletonThreadUnsafe();

    private SingletonThreadUnsafe() {
    }

    public static SingletonThreadUnsafe getSingleton() {
        return singleton;
    }
}
