package com.jools.highconcurrency.countdownlatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/1/28 0:31
 * @description: TODO
 */
public class ThreadContext {

    volatile List<Object> list = new ArrayList<>();

    public void add(int i) {
        list.add(i);
    }

    public int getSize() {
        return list.size();
    }

    public static void main(String[] args) {

        ThreadContext T = new ThreadContext();
        CountDownLatch countDownLatch = new CountDownLatch(1);

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Watcher thread started!");
                if (T.getSize() != 5) {
                    try {
                        countDownLatch.await();
                        System.exit(0);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }, "Watcher").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Writer thread starter !!");
                for (int i = 1; i <= 10; i++) {
                    T.add(i);
                    System.out.println("Writer adding:" + i);
                    if (T.getSize() == 5) {
                        System.out.println("Notify Watcher !!!");
                        countDownLatch.countDown();
                        break;
                    }
                }
            }
        }, "Writer").start();

        /*
         输出:
            Watcher thread started!
            Writer thread starter !!
            Writer adding:1
            Writer adding:2
            Writer adding:3
            Writer adding:4
            Writer adding:5
            Notify Watcher !!!
        */
    }
}
