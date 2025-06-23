package com.jools.concurrent;

/**
 * @author Jools He
 * @date 2025/6/18 16:47
 * @description: TODO
 */
public class NapTask implements Runnable {

    final int id;

    public NapTask(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        new Nap(0.1);   // 休眠 0.1 秒
        System.out.println(this + " " +
                Thread.currentThread().getName());
    }

    @Override
    public String toString() {
        return "NapTask[" +
                "id=" + id +
                ']';
    }
}
