package com.jools.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * @author Jools He
 * @date 2025/6/20 15:48
 * @description: TODO
 */
public class CapUncaughtException {

    public static void main(String[] args) {

        // 通过自定义ThreadFactory 创建线程
        ExecutorService exec = Executors.newCachedThreadPool(
                new HandlerThreadFactory()
        );
        exec.execute(new ExceptionThread2());
        exec.shutdown();

        /*
         输出:
           com.jools.concurrent.HandlerThreadFactory@31cefde0 creating new thread
            Factory created: Thread[Thread-0,5,main]
            exception handler: com.jools.concurrent.MyUncaughtExceptionHandler@2e0fa5d3
            run() by Thread-0
            current exception handler: com.jools.concurrent.MyUncaughtExceptionHandler@2e0fa5d3
            Caught Exception: java.lang.RuntimeException
        */
    }
}

class ExceptionThread2 implements Runnable {

    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        System.out.println("run() by " + thread.getName());
        System.out.println("current exception handler: " +
                thread.getUncaughtExceptionHandler());
        throw new RuntimeException();
    }
}

class MyUncaughtExceptionHandler implements
        Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("Caught Exception: " + e);
    }
}

class HandlerThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        System.out.println(this + " creating new thread");
        Thread t = new Thread(r);
        System.out.println("Factory created: " + t);

        // 绑定该 Thread 对象异常处理程序
        t.setUncaughtExceptionHandler(
                new MyUncaughtExceptionHandler()
        );
        System.out.println("exception handler: " + t.getUncaughtExceptionHandler());
        return t;
    }
}
