package com.jools.highconcurrency;

import java.util.concurrent.CountDownLatch;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/1/21 23:16
 * @description: TODO
 */
public class CountDownLatchDemo {

    public static void main(String[] args) {

        CountDownLatch latch = new CountDownLatch(3);


        for(int i = 0; i < 3; i++) {
            new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + " 正在执行任务...");
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + " 执行任务完成....");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    latch.countDown();
                }
            }).start();
        }

        System.out.println("主线程开启任务，等待子线程完成....");
        latch.countDown();
        System.out.println("主线程任务完成 !!!");
    }
}
