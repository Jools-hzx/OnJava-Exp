package com.jools.designpattern.observer;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/1/19 21:13
 * @description: TODO
 */
public class InterfaceDefaultDemo {
}

class AnImplementation implements AnInterface {

    @Override
    public void firstMethod() {
        System.out.println("FirstMethod!");
    }

    @Override
    public void secondMethod() {
        System.out.println("SecondMethod!!");
    }

    public static void main(String[] args) {
        AnImplementation impl = new AnImplementation();
        impl.firstMethod();
        impl.secondMethod();

        //如果需要将另外一个方法 newMethod() 添加到 AnInterface
    }
}

interface AnInterface {

    void firstMethod();

    void secondMethod();

    default void newMethod() {
        System.out.println("This is a new default method!!!");
    };
}