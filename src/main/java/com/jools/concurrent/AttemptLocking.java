package com.jools.concurrent;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Jools He
 * @date 2025/6/20 22:34
 * @description: TODO
 */
public class AttemptLocking {

    private ReentrantLock lock = new ReentrantLock();

    // 不限制时间获取锁
    public void untimed() {
        boolean getLock = lock.tryLock();
        try {
            System.out.println("tryLock(): " + getLock);
        } finally {
            if (getLock) {
                lock.unlock();
            }
        }
    }

    // 限时获取锁
    public void timed() {
        boolean captured = false;
        try {
            captured = lock.tryLock(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            System.out.println("tryLock(): " + captured);
        } finally {
            if (captured) {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        final AttemptLocking atLock = new AttemptLocking();
        atLock.untimed();   // 获取锁 (仅 main() 获取) 输出: true
        atLock.timed();     // 获取锁 (仅 main() 获取) 输出: true

        // 第二个任务尝试获取锁
        CompletableFuture.runAsync(
                () -> {
                    atLock.lock.lock();
                    System.out.println(Thread.currentThread().getId() + "  lock acquired");
                }
        );
        new Nap(0.1);   // 第二个任务抢占锁
        atLock.untimed();   // 被第二个任务获取锁 main() 获取失败，输出: false
        atLock.timed();     // 被第二个任务获取了锁 main() 获取失败, 输出: false

        /*
         输出结果:
            tryLock(): true
            tryLock(): true
            24  lock acquired
            tryLock(): false
            tryLock(): false
        */
    }
}
