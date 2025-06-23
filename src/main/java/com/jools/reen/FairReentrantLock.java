package com.jools.reen;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/1/31 2:33
 * @description: TODO
 */
public class FairReentrantLock {

    public static void main(String[] args) {
        ReentrantLock fairReentrantLock = new ReentrantLock(true);

        //三个线程持有同一个 ReentrantLock 实例
        ThreadDemo t1 = new ThreadDemo("T1", fairReentrantLock);
        ThreadDemo t2 = new ThreadDemo("T2", fairReentrantLock);
        ThreadDemo t3 = new ThreadDemo("T3", fairReentrantLock);

        t1.start();
        t2.start();
        t3.start();

        /*
         输出结果，某一次：
            Thread[T1,5,main] running...
            Thread[T2,5,main] running...
            Thread[T3,5,main] running...
        */
    }
}

class ThreadDemo extends Thread {

    private Lock lock;

    public ThreadDemo(String name, Lock lock) {
        super(name);
        this.lock = lock;
    }

    @Override
    public void run() {
        lock.lock();

        System.out.println(Thread.currentThread() + " running...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }
}
