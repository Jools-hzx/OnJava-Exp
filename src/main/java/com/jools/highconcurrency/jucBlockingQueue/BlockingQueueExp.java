package com.jools.highconcurrency.jucBlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/1/29 1:04
 * @description: TODO
 */
public class BlockingQueueExp {

    public static void main(String[] args) {

        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(1024);

        Consumer consumer = new Consumer(blockingQueue);
        Producer producer = new Producer(blockingQueue);

        // 启动
        producer.start();
        consumer.start();

        /*
         输出:
            Put value:0
            获取队首元素:0
            阻塞时长:4
            Put value:1
            获取队首元素:1
            阻塞时长:1008
            Put value:2
            获取队首元素:2
            阻塞时长:1004
            Put value:3
            获取队首元素:3
            阻塞时长:1016
            Put value:4
            获取队首元素:4
            阻塞时长:1012
        */
    }
}

class Consumer extends Thread {

    private BlockingQueue<String> blockingQueue;

    public Consumer(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                long start = System.currentTimeMillis();
                System.out.println("获取队首元素:" + this.blockingQueue.take());
                long end = System.currentTimeMillis();
                System.out.println("阻塞时长:" + (end - start));
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}


class Producer extends Thread {

    private BlockingQueue<String> blockingQueue;

    public Producer(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("Put value:" + i);
                blockingQueue.put(String.valueOf(i));
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
