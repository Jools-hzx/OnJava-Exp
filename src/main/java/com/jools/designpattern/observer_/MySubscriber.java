package com.jools.designpattern.observer_;

import java.util.concurrent.Flow;

/**
 * @author Jools He
 * @date 2025/6/23 1:01
 * @description: 自定义订阅者
 * 需要指定从发布者接收到的数据类型
 * 模拟事件: 请求一定数量的数据，并且根据需要分批请求
 */
public class MySubscriber implements Flow.Subscriber<Message> {

    // 用于持有来自订阅者的控制器（其实并不必要）
    private Flow.Subscription subscription;

    // 每轮数量
    private int perNum;

    // 计数器(最多请求次数)
    private int count;

    // 设置每轮订阅次数和总次数
    public MySubscriber(int perNum, int count) {
        this.perNum = perNum;
        this.count = count;
    }

    private void startNewRound() {
        System.out.println("Start a new round");
        // 单次可请求数量范围: [0 ~ perNum]
        int requestCount = Math.min(count, perNum);
        count -= requestCount;
        subscription.request(requestCount);
    }

    // 订阅 - 发出第一次请求
    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        // 发起第一轮请求
        startNewRound();
    }

    // 接收 Publisher 传递的数据 - 发出后续请求
    @Override
    public void onNext(Message item) {
        System.out.println("receive message: " + item.msg);
        System.out.println("now left: " + item.leftCount);
        // 本轮结束的时候，开启下一轮
        if (item.leftCount == 0 && count > 0) {
            startNewRound();
        }
    }

    // 接收 Publisher 产生错误
    @Override
    public void onError(Throwable throwable) {
        System.out.println("onError:" + throwable.getMessage());
    }

    // 接收发布者完成的指令
    @Override
    public void onComplete() {
        System.out.println("onComplete!");
    }
}
