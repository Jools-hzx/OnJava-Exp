package com.jools.highconcurrency.threadpool;

import cn.hutool.core.thread.ThreadUtil;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/1/29 21:44
 * @description: TODO
 */

public class TestCallerRunsPolicy {

    public static void main(String[] args) {

        /*
         创建线程池：核心线程数目为 1
         最大线程数目为 2
         当线程数目大于核心线程数目的时候，多余的空闲线程存活的最大时间设置为 60s
         任务队列容量为 1 的 ArrayBlockingQueue

         如果队列已满并且已经为最大线程数目，则第四个线程到来会阻塞
        */
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(
                1,
                2,
                60,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(1),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );

        long start = System.currentTimeMillis();

        // 提交第一个任务，由核心线程执行
        poolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                ThreadUtil.sleep(1, TimeUnit.MINUTES);
            }
        });

        // 第二个任务，由于核心线程被占用，任务将进入队列等待
        poolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("非核心线程执行第二个任务");
                ThreadUtil.sleep(1, TimeUnit.MINUTES);
            }
        });

        // 第三个任务，由于核心线程被占用且队列已满，创建非核心线程
        poolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("非核心线程执行第三个任务");
                ThreadUtil.sleep(1, TimeUnit.MINUTES);
            }
        });


        // 第四个任务，由于核心线程和非核心线程都被占用，队列也满了，根据CallerRunsPolicy策略，任务将由提交任务的线程（即主线程）来执行
        poolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("非核心线程执行第四个任务");
                ThreadUtil.sleep(2, TimeUnit.MINUTES);
            }
        });

        // 第五个任务，主线程被第四个任务卡住，该任务必须等待主线程执行完之后再提交
        poolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("第五个任务执行");
            }
        });

        poolExecutor.shutdown();


        long end = System.currentTimeMillis();

        System.out.println("耗时: " + (end - start));
    }
}
