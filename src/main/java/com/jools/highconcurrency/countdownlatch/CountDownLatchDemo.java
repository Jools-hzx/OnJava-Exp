package com.jools.highconcurrency.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/1/27 23:34
 * @description: TODO
 */
public class CountDownLatchDemo {

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(2);

        CountDownThread thread01 = new CountDownThread(countDownLatch);
        CountDownThread thread02 = new CountDownThread(countDownLatch);

        thread01.start();
        thread02.start();

        System.out.println("Waiting all thread finishing!!");
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + "All thread complete!! Continue....");

        /*
         输出结果:
            Thread-0 is executing!!!
            Thread-1 is executing!!!
            Thread-0 finish!!!
            Thread-1 finish!!!
            mainAll thread complete!! Continue....
        */
    }
}

class CountDownThread extends Thread {

    private CountDownLatch count;

    public CountDownThread(CountDownLatch count) {
        this.count = count;
    }

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName() + " is executing!!!");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + " finish!!!");
        this.count.countDown();
    }
}
