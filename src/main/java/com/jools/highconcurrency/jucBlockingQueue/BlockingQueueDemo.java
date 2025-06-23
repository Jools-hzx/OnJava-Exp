package com.jools.highconcurrency.jucBlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/1/28 3:25
 * @description: TODO
 */
public class BlockingQueueDemo {

    public static void main(String[] args) {

        ConcurrentLinkedQueue<Integer> concurrentLinkedQueue = new ConcurrentLinkedQueue<>();

        GetThread getThread = new GetThread(concurrentLinkedQueue);
        PutThread putThread = new PutThread(concurrentLinkedQueue);
        putThread.start();
        getThread.start();

        /*
         输出结果:
            Thread-1 writed:0
            Thread-0 poll: null
            Thread-1 writed:1
            Thread-0 poll: 0
            Thread-0 poll: 1
            Thread-1 writed:2
            Thread-0 poll: 2
            Thread-1 writed:3
            Thread-1 writed:4
            Thread-0 poll: 3
            Thread-0 poll: 4
        */
    }
}

class GetThread extends Thread {
    private ConcurrentLinkedQueue<Integer> queue;

    public GetThread(ConcurrentLinkedQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 6; i++) {
            try {
                Integer ans = queue.poll();
                System.out.println(Thread.currentThread().getName() + " poll: " + ans);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class PutThread extends Thread {

    private ConcurrentLinkedQueue<Integer> queue;

    public PutThread(ConcurrentLinkedQueue<Integer> queue) {
        this.queue = queue;
    }


    @Override
    public void run() {

        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " writed:" + i);
            queue.offer(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}