package com.jools.highconcurrency.aqs;

import java.util.concurrent.Semaphore;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/1/26 23:43
 * @description: TODO
 */
public class SemaphoreDemo {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(10); // 允许两个线程同时访问

        for (int i = 0; i < 9; i++) {
            new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + " 等待许可证...");
                    semaphore.acquire(); // 获取许可证
                    System.out.println(Thread.currentThread().getName() + " 获得许可证，正在执行任务...");
                    Thread.sleep(2000); // 模拟任务
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println(Thread.currentThread().getName() + " 释放许可证");
                    semaphore.release(); // 释放许可证
                }
            }).start();
        }

        /*
         输出: 进行顺序 [678] [025]  [413]  执行的次序 [867] [502] [413]  符合 FIFO 顺序
            Thread-8 等待许可证...
            Thread-6 等待许可证...
            Thread-7 等待许可证...
            Thread-8 获得许可证，正在执行任务...
            Thread-6 获得许可证，正在执行任务...
            Thread-0 等待许可证...
            Thread-2 等待许可证...
            Thread-7 获得许可证，正在执行任务...
            Thread-5 等待许可证...
            Thread-4 等待许可证...
            Thread-1 等待许可证...
            Thread-3 等待许可证...
            Thread-6 释放许可证
            Thread-8 释放许可证
            Thread-5 获得许可证，正在执行任务...
            Thread-0 获得许可证，正在执行任务...
            Thread-7 释放许可证
            Thread-2 获得许可证，正在执行任务...
            Thread-5 释放许可证
            Thread-4 获得许可证，正在执行任务...
            Thread-0 释放许可证
            Thread-1 获得许可证，正在执行任务...
            Thread-2 释放许可证
            Thread-3 获得许可证，正在执行任务...
            Thread-1 释放许可证
            Thread-4 释放许可证
            Thread-3 释放许可证
        */
    }
}
