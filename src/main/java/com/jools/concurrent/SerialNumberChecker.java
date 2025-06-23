package com.jools.concurrent;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;

/**
 * @author Jools He
 * @date 2025/6/20 17:01
 * @description: TODO
 */
public class SerialNumberChecker implements Runnable {

    private CircularSet serials = new CircularSet(1000);

    private SerialNumbers producer;

    public SerialNumberChecker(SerialNumbers producer) {
        this.producer = producer;
    }

    @Override
    public void run() {
        while (true) {
            int serial = producer.nextSerialNumber();
            if (serials.contains(serial)) {
                System.out.println("存在重复元素: " + serial);
                System.exit(0);
            }
            serials.add(serial);
        }
    }

    // test() 创建多个 SerialNumberChecker 任务来争夺一个 SerialNumbers 对象
    static void test(SerialNumbers producer) {
        for (int i = 0; i < 10; i++) {
            CompletableFuture.runAsync(
                    new SerialNumberChecker(producer)
            );
        }
        new Nap(4, "无重复元素!");
    }
}

class CircularSet {

    private int[] array;
    private int size;
    private int index = 0;

    public CircularSet(int size) {
        this.size = size;
    }

    // 添加并覆盖
    public synchronized void add(int i) {
        array[index] = i;
        // 包装所以，覆盖旧的元素
        index = ++index % size;
    }

    // 校验是否存在 val
    public synchronized boolean contains(int val) {
        for (int i = 0; i < size; i++) {
            if (array[i] == val) {
                return true;
            }
        }
        return false;
    }
}

class SerialNumbers {

    // 使用 volatile 修饰; 校验是否会起作用
    private volatile int serialNumber = 0;

    public int nextSerialNumber() {
        return serialNumber++;
    }
}