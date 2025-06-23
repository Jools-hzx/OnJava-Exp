package com.jools.concurrent;

import com.jools.collections_.Pair;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;

/**
 * @author Jools He
 * @date 2025/6/20 17:57
 * @description: TODO
 */
public class SynchronizedComparsion {

    static void test(Guarded g) {
        List<CompletableFuture<Void>> callers = Stream.of(
                        new Caller(g),
                        new Caller(g),
                        new Caller(g),
                        new Caller(g)
                ).map(CompletableFuture::runAsync)
                .toList();
        callers.forEach(CompletableFuture::join);
        System.out.println(g);
    }

    public static void main(String[] args) {
        test(new CriticalSection());
        test(new SynchronizedMethod());
    }
}

abstract class Guarded {

    AtomicLong callCount = new AtomicLong();

    public abstract void method();

    @Override
    public String toString() {
        return getClass().getSimpleName() + ": " + callCount.get();
    }
}

// 使用同步方法
class SynchronizedMethod extends Guarded {
    @Override
    public void method() {
        new Nap(0.01);
        callCount.incrementAndGet();
    }
}

// 使用同步代码块
class CriticalSection extends Guarded {

    @Override
    public void method() {
        new Nap(0.01);
        synchronized (this) {
            callCount.incrementAndGet();
        }
    }
}

class Caller implements Runnable {

    private Guarded g;

    public Caller(Guarded g) {
        this.g = g;
    }

    private AtomicLong successfulCalls = new AtomicLong();

    private AtomicBoolean stop = new AtomicBoolean(false);

    @Override
    public void run() {
        new Timer().schedule(
                new TimerTask() {
                    @Override
                    public void run() {
                        stop.set(true);
                    }
                }
                , 2500);
        while (!stop.get()) {
            g.method();
            successfulCalls.getAndIncrement();
        }
        System.out.println(" -> " + successfulCalls.get());
    }
}
