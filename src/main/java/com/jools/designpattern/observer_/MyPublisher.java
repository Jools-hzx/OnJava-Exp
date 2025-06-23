package com.jools.designpattern.observer_;

import java.util.Date;
import java.util.concurrent.Flow;

/**
 * @author Jools He
 * @date 2025/6/23 0:52
 * @description: 自定义发布者
 */
public class MyPublisher implements Flow.Publisher<Message> {

    // 总计数器(从 0 开始): 记录 subscribe 请求次数
    private int count = 0;

    // 最多请求次数
    private final int maxCount;

    // 剩余计数器(从 0 开始): 记录 onNext 请求次数
    private int leftCount = 0;

    // 每次处理请求的间隔时长
    private final long interval;

    // 是否已经取消订阅
    private boolean isCancelled;


    public MyPublisher(int maxCount, long interval) {
        this.maxCount = maxCount;
        this.interval = interval;
    }

    /**
     * 订阅事件; 定义订阅者定义后的操作，通常是在某个条件下传递一个对象给订阅者
     *
     * @param subscriber the subscriber
     */
    @Override
    public void subscribe(Flow.Subscriber<? super Message> subscriber) {
        // 使用线程来异步执行每个订阅操作
        new Thread(() -> {
            try {
                // 给订阅者分配一个控制器
                subscriber.onSubscribe(new MySubscription());
                // 循环执行核心操作
                while (!isCancelled && count < maxCount) {
                    // 当剩余数量大于 0, 传递数据给订阅者
                    if (leftCount > 0) {
                        subscriber.onNext(
                                new Message(
                                        new Date() + ":" + (++count),
                                        --leftCount     // 更新设关于可请求次数
                                ));
                        Thread.sleep(interval);
                    }
                }
                // 结束订阅后，通知订阅者
                subscriber.onComplete();
            } catch (Exception e) {
                // 错误; 通知订阅者
                subscriber.onError(e);
            }
        }).start();
    }

    /**
     * 自定义订阅控制类；
     * 重写 request 和 cancel 方法，提供给订阅者使用
     */
    private class MySubscription implements Flow.Subscription {

        /**
         * 接收来自订阅者的数据请求
         */
        @Override
        public void request(long n) {
            // 累加到剩余次数
            leftCount += n;
        }

        /**
         * 取消订阅
         */
        @Override
        public void cancel() {
            isCancelled = true;
        }
    }
}


