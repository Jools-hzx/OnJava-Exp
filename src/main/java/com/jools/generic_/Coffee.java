package com.jools.generic_;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/18 17:58
 * @description: TODO
 */
public class Coffee {

    private static long counter = 0;
    private final long id = counter++;

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + id;
    }
}

class Latte extends Coffee {}

class Mocha extends Coffee {}

class Cappuccino extends Coffee {}

class Americano extends Coffee {}

class Breve extends Coffee {}
