package com.jools.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Jools He
 * @date 2025/6/20 17:33
 * @description: TODO
 */
public class AtomicSerialNumbers extends SerialNumbers {

    private AtomicInteger serialNumber = new AtomicInteger();

    @Override
    public int nextSerialNumber() {
        return serialNumber.getAndIncrement();
    }

    public static void main(String[] args) {
        SerialNumberChecker.test(new AtomicSerialNumbers());
    }
}
