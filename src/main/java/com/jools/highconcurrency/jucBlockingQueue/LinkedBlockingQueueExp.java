package com.jools.highconcurrency.jucBlockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/1/29 1:52
 * @description: TODO
 */
public class LinkedBlockingQueueExp {

    public static void main(String[] args) {

        // 创建一个容量为 10 的 LinkedBlockingQueue
        BlockingQueue<String> queue = new LinkedBlockingQueue<>(10);

        //创建并启动生产者消费者线程
        Thread producer = new Thread(new ItemProducer(queue));
        producer.start();

        Thread consumer = new Thread(new ItemConsumer(queue));
        consumer.start();

        /*
        输出:
        Produced:Item-0
        Consumer take:Item-0
        Produced:Item-1
        Consumer take:Item-1
        Produced:Item-2
        Produced:Item-3
        Consumer take:Item-2
        Produced:Item-4
        Produced:Item-5
        Consumer take:Item-3
        Produced:Item-6
        Produced:Item-7
        Consumer take:Item-4
        Produced:Item-8
        Produced:Item-9
        Consumer take:Item-5
        Consumer take:Item-6
        Consumer take:Item-7
        Consumer take:Item-8
        Consumer take:Item-9
        */
    }
}

class ItemConsumer implements Runnable {

    private final BlockingQueue<String> queue;

    public ItemConsumer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        String headItem = null;
        try {
            for (int i = 0; i < 10; i++) {
                headItem = queue.take();    // 阻塞直到队列都有数据可消费
                System.out.println("Consumer take:" + headItem);
                Thread.sleep(1000);     // 模拟消费过程的延迟
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class ItemProducer implements Runnable {

    private final BlockingQueue<String> queue;

    public ItemProducer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        int itemNumber = 0;
        try {
            for (int i = 0; i < 10; i++) {
                String item = "Item-" + itemNumber++;
                queue.put(item);    //阻塞直到队列有空闲空间
                System.out.println("Produced:" + item);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
