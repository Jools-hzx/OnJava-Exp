package com.jools.designpattern.singleton;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/1/8 20:28
 * @description: TODO
 */
public class TestSingletonObjClient {

    @Test
    public void testEnum() {
        Singleton instance01 = Singleton.INSTANCE;
        Singleton instance02 = Singleton.INSTANCE;
        Assert.assertEquals(instance01, instance02);
    }

    @Test
    public void testStaticInnerClassSingleton() {
        StaticInnerClassSingleton instance01 = StaticInnerClassSingleton.getInstance();
        StaticInnerClassSingleton instance02 = StaticInnerClassSingleton.getInstance();

        Assert.assertEquals(instance01, instance02);
        System.out.println(instance01);
        System.out.println(instance02);
        /*
        com.jools.designpattern.singleton.StaticInnerClassSingleton@4ec6a292
        com.jools.designpattern.singleton.StaticInnerClassSingleton@4ec6a292
         */
    }

    @Test
    public void testLazySingletonInstance() {
        LazySingletonObject singleton = LazySingletonObject.getSingleton();
        LazySingletonObject newSingleton = LazySingletonObject.getSingleton();
        Assert.assertEquals(singleton, newSingleton);
    }

    public static void main(String[] args) {

        SingletonThreadUnsafe singleton = SingletonThreadUnsafe.getSingleton();
        SingletonThreadUnsafe newSingleton = SingletonThreadUnsafe.getSingleton();
        Assert.assertEquals(singleton, newSingleton);

        System.out.println(singleton);
        System.out.println(newSingleton);

        /*
        输出:
        com.jools.designpattern.singleton.SingletonThreadUnsafe@5fd0d5ae
        com.jools.designpattern.singleton.SingletonThreadUnsafe@5fd0d5ae
         */
    }

    @Test
    public void testDoubleLocksSingleton() {
        DoubleLocksSingleton instance01 = DoubleLocksSingleton.getInstance();
        DoubleLocksSingleton instance02 = DoubleLocksSingleton.getInstance();
        Assert.assertEquals(instance01, instance02);
        System.out.println(instance01);
        System.out.println(instance02);
    }
}
