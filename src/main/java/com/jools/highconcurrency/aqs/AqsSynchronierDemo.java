package com.jools.highconcurrency.aqs;

import com.jools.designpattern.abstractFactory.Main;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/1/22 22:19
 * @description: TODO
 */
public class AqsSynchronierDemo {

    public static void main(String[] args) {

        MyAQSLock lock = new MyAQSLock();

        Runnable task = () -> {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " 获得锁!!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                System.out.println(Thread.currentThread().getName() + " 释放锁");
                lock.unlock();
            }
        };

        ExecutorService executorService = Executors.newFixedThreadPool(1);

        for (int i = 0; i < 3; i++) {
            new Thread(task).start();
        }

        /*
         输出:
            Thread-0 获得锁!!
            Thread-0 释放锁
            Thread-1 获得锁!!
            Thread-1 释放锁
            Thread-2 获得锁!!
            Thread-2 释放锁
         */
    }
}

class MyAQSLock {

    private final Sync sync = new Sync();

    public void lock() {
        sync.acquire(1);
    }

    public void unlock() {
        sync.release(1);
    }

    public boolean isLocked() {
        return sync.isHeldExclusively();
    }

    private static class Sync extends AbstractQueuedSynchronizer {

        @Override
        protected boolean tryAcquire(int arg) {
            // 尝试获取锁，仅当 state == 0 的时候获取
            if (compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {
            //尝试释放锁，仅当当前线程持有锁的时候可以释放
            if (getState() == 0) {
                throw new RuntimeException("Hahahaha!!!");
            }
            setExclusiveOwnerThread(null);  //释放
            setState(0);    //设置为 0
            return true;
        }

        @Override
        protected boolean isHeldExclusively() {
            return getState() == 1 && Thread.currentThread() == getExclusiveOwnerThread();
        }
    }
}
