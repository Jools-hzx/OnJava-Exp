package com.jools.highconcurrency.cyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/1/28 1:07
 * @description: TODO
 */
public class CyclicBarrierDemo {

    final static int threadCount = 3;
    static CyclicBarrier barrier = new CyclicBarrier(threadCount, () -> System.out.println("所有线程都抵达该屏障，执行后续...."));

    public static void main(String[] args) {
        for (int i = 0; i < threadCount; i++) {
            new T(barrier).start();
        }

        /*
         输出:
            Thread-2 正在执行任务...
            Thread-1 正在执行任务...
            Thread-0 正在执行任务...
            Thread-0 到达屏障
            Thread-1 到达屏障
            Thread-2 到达屏障
            所有线程都抵达该屏障，执行后续....
        */
    }
}

class T extends Thread {

    private CyclicBarrier barrier;

    public T(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " 正在执行任务...");
        try {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " 到达屏障");
            this.barrier.await(); // 等待其他线程
        } catch (InterruptedException | BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }
}

