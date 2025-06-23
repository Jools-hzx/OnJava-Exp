package com.jools.highconcurrency.jucBlockingQueue;

import java.util.Objects;
import java.util.concurrent.*;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/1/29 1:22
 * @description: TODO
 */
public class ArrayBlockingQueueDemo {

    public static void main(String[] args) {

        DelayQueue<DelayedElement> delayQueue = new DelayQueue<>();

        DelayedElement element01 = new DelayedElement();
        DelayedElement element02 = new DelayedElement();
        DelayedElement element03 = new DelayedElement();

        delayQueue.put(element01);
        delayQueue.put(element02);
        delayQueue.put(element03);

        System.out.println("Put element: " + element01);
        System.out.println("Put element: " + element02);
        System.out.println("Put element: " + element03);

        try {
            for (int i = 0; i < 3; i++) {
                DelayedElement take = delayQueue.take();
                System.out.println("Take head element:" + take);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        /*
         输出:
            Put element: DelayedElement{expirationTime=932499523198000}
            Put element: DelayedElement{expirationTime=932499523208400}
            Put element: DelayedElement{expirationTime=932499523208700}
            Take head element:DelayedElement{expirationTime=932499523198000}
            Take head element:DelayedElement{expirationTime=932499523208400}
            Take head element:DelayedElement{expirationTime=932499523208700}
        */
    }
}

class DelayedElement implements Delayed {

    // 到期时间戳（以纳秒为单位）
    private final long expirationTime;

    public DelayedElement() {
        // 设置 3 秒的过期时间
        this.expirationTime = System.nanoTime() + TimeUnit.SECONDS.toNanos(3);
    }

    @Override
    public long getDelay(TimeUnit unit) {
        // 计算剩余时间
        long remainingTime = expirationTime - System.nanoTime();
        return unit.convert(remainingTime, TimeUnit.NANOSECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        // 按照从小到大排序
        return Long.compare(this.getDelay(TimeUnit.NANOSECONDS), o.getDelay(TimeUnit.NANOSECONDS));
    }

    @Override
    public String toString() {
        return "DelayedElement{" +
                "expirationTime=" + expirationTime +
                '}';
    }
}
