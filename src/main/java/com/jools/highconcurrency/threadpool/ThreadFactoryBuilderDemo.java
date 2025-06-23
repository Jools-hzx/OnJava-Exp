package com.jools.highconcurrency.threadpool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/1/29 22:49
 * @description: TODO
 */
public class ThreadFactoryBuilderDemo {

    static final String threadNamePrefix = "test-thread-name-prefix:";

    public static void main(String[] args) {


        ThreadFactory threadFactory = new ThreadFactoryBuilder()
                .setNameFormat(threadNamePrefix + "---- Jools Wakoo")
                .setDaemon(true)
                .build();

        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(
                1,
                2,
                60,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(1),
                threadFactory);

        Runnable target = () -> {
            String name = Thread.currentThread().getName();
            System.out.println(name);
        };

        poolExecutor.execute(target);
        poolExecutor.execute(target);

        poolExecutor.shutdown();

        /*
         输出:
            test-thread-name-prefix:----Jools Wakoo
            test-thread-name-prefix:----Jools Wakoo
        */
    }
}
