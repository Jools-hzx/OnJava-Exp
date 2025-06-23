package com.jools.highconcurrency.aqs.semaphore;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class FixSizeSemaphoreDemo {


    @Test
    public void testSemaphoreRelease() {
        int permitNum = 2;
        final Semaphore semaphore = new Semaphore(permitNum);

        try {
            System.out.println("availablePermits:" + semaphore.availablePermits() + ", \tsemaphore.tryAcquire(3,1, TimeUnit.SECONDS):" + semaphore.tryAcquire(3, 1, TimeUnit.SECONDS));
            semaphore.release();
            System.out.println("availablePermits:" + semaphore.availablePermits() + ", \tsemaphore.tryAcquire(3,1, TimeUnit.SECONDS):" + semaphore.tryAcquire(3, 1, TimeUnit.SECONDS));
        } catch (Exception e) {

        }

        /*
         输出结果:
            availablePermits:2, 	semaphore.tryAcquire(3,1, TimeUnit.SECONDS):false
            availablePermits:3, 	semaphore.tryAcquire(3,1, TimeUnit.SECONDS):true
        */
    }

    @Test
    public void testSameThreadCallNTimes() {

        // 初始化 Semaphore，令牌数量为 10
        Semaphore semaphore = new Semaphore(10);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " 开始尝试获取许可证....");
                try {
                    for (int i = 0; i < 11; i++) {  // 重复调用 11 次 acquire 方法
                        System.out.println(Thread.currentThread().getName() + " 正在尝试第 " + (i + 1) + " 次 acquire()...");
                        semaphore.acquire();    // 获取许可证
                        System.out.println(Thread.currentThread().getName() + " 成功获取第 " + (i + 1) + " 个许可证");
                    }
                    System.out.println(Thread.currentThread().getName() + " 已获取所有许可证，正在执行任务...");
                    Thread.sleep(2000); // 模拟任务
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    System.out.println(Thread.currentThread().getName() + " 释放所有许可证");
                    semaphore.release(11);  // 释放所有已获取的许可证
                }
            }
        };

        Thread target = new Thread(runnable);

        target.start();

        try {
            target.join(); // 主线程等待子线程执行完成
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {


        Semaphore semaphore = new Semaphore(1);
        // 初始化一个线程
        Runnable runnable01 = new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName() + " 等待许可证...");
                    semaphore.acquire(); // 获取许可证
                    System.out.println(Thread.currentThread().getName() + " 获得许可证，正在执行任务...");
                    Thread.sleep(2000); // 模拟任务
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println(Thread.currentThread().getName() + " 释放 2 个许可证");
                    //之后释放两次
                    semaphore.release();
                    semaphore.release();
                }
            }
        };

        Runnable runnable02 = new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName() + " 等待许可证...");
                    semaphore.acquire(2); // 获取许可证
                    System.out.println(Thread.currentThread().getName() + " 获得许可证，正在执行任务...");
                    Thread.sleep(2000); // 模拟任务
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println(Thread.currentThread().getName() + " 释放 2 个许可证");
                    //之后释放两次
                    semaphore.release();
                    semaphore.release();
                    System.out.println("最终状态:" + semaphore.availablePermits());
                }
            }
        };

        Thread target01 = new Thread(runnable01);
        Thread target02 = new Thread(runnable02);

        System.out.println("初始状态下:" + semaphore.availablePermits());

        //第一次先尝试获取
        target01.start();

        //释放之后尝试一次性获取 2
        target02.start();



        /*
            Thread-0 等待许可证...
            Thread-1 等待许可证...
            Thread-0 获得许可证，正在执行任务...
            Thread-0 释放 2 个许可证
            Thread-1 获得许可证，正在执行任务...
            Thread-1 释放 2 个许可证
         */
    }
}
