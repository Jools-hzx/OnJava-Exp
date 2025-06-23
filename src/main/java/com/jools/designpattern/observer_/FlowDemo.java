package com.jools.designpattern.observer_;

/**
 * @author Jools He
 * @date 2025/6/23 1:06
 * @description: TODO
 */
public class FlowDemo {

    public static void main(String[] args) throws InterruptedException {

        // 发布者: 每 500ms 发送一次，最多 20 次
        MyPublisher publisher = new MyPublisher(10, 500L);
        // 订阅者: 每轮 3 条数据，总共 4 轮 [前三轮可发三次,最后一轮仅有一次]
        MySubscriber subscriber = new MySubscriber(3, 20);

        publisher.subscribe(subscriber);

        Thread.currentThread().join();
    }
}
