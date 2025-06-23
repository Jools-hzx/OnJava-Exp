package com.jools.highconcurrency.aqs;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/1/22 22:53
 * @description: TODO
 */
public class SpinLock {

    private AtomicReference<Thread> owner = new AtomicReference<>();

    public void lock() {
        Thread currentThread = Thread.currentThread();
        // 如果锁未被占用，则设置当前线程为锁的拥有者
        while (!owner.compareAndSet(null, currentThread)) {

        }
    }

    public void unLock() {
        Thread currentThread = Thread.currentThread();

        // 只有锁的拥有者才能够释放锁
        owner.compareAndSet(currentThread, null);
    }
}
