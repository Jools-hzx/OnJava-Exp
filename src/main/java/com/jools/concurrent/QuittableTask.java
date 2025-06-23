package com.jools.concurrent;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author Jools He
 * @date 2025/6/19 15:32
 * @description: TODO
 */
public class QuittableTask implements Runnable {

    final int id;

    public QuittableTask(int id) {
        this.id = id;
    }

    private AtomicBoolean running = new AtomicBoolean(true);

    // 设置共享可变状态为 false
    public void quit() {
        running.set(false);
    }

    @Override
    public void run() {
        while (running.get()) { // [1]: 只要 running 标识还是 true, 该任务的 run() 方法就会持续执行
            new Nap(0.1);
        }
        System.out.print(id + " - "); // [2]: 任务退出之后才会执行
    }
}
