package com.jools.highconcurrency.countdownlatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/1/28 0:17
 * @description: TODO
 */
public class CountDownLatchContext {

    public static void main(String[] args) {

        CountDownLatch count = new CountDownLatch(1);
        CountDownLatchContext context = new CountDownLatchContext(count, new ArrayList<>());

        Writer writer = new Writer(count, context);
        Watcher watcher = new Watcher(count, context);

        watcher.start();
        writer.start();
    }

    private CountDownLatch countDownLatch;

    List<Object> list;

    public CountDownLatchContext(CountDownLatch countDownLatch, List<Object> list) {
        this.countDownLatch = countDownLatch;
        this.list = list;
    }

    public boolean add(Object element) {
        try {
            list.add(element);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public int size() {
        return list.size();
    }
}

class Writer extends Thread {

    private CountDownLatch countDownLatch;
    private CountDownLatchContext context;

    public Writer(CountDownLatch countDownLatch, CountDownLatchContext context) {
        this.countDownLatch = countDownLatch;
        this.context = context;
    }

    @Override
    public void run() {
        int curr = 1;
        while (context.size() < 5) {
            context.add(curr++);
        }
        System.out.println("Current list size:" + context.size());
        countDownLatch.countDown();
    }
}

class Watcher extends Thread {

    private CountDownLatch countDownLatch;

    private CountDownLatchContext context;

    public Watcher(CountDownLatch countDownLatch, CountDownLatchContext context) {
        this.countDownLatch = countDownLatch;
        this.context = context;
    }

    @Override
    public void run() {
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("Finish!!!");
            System.out.println(this.context.size() + "  List:" + this.context.list);
            System.exit(0);
        }
    }
}

