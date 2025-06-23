package com.jools.concurrent;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author Jools He
 * @date 2025/6/20 19:00
 * @description: TODO
 */
public class SyncOnObject {

    static void test(boolean fNap, boolean gNap) {
        DualSynch ds = new DualSynch();
        List<CompletableFuture<Void>> cfs = Arrays.stream(new Runnable[]{
                        () -> ds.f(fNap),
                        () -> ds.g(gNap)
                }).map(CompletableFuture::runAsync)
                .toList();
        cfs.forEach(CompletableFuture::join);
        ds.trace.forEach(System.out::println);
    }

    public static void main(String[] args) {
        test(true, false);
        System.out.println("*****");
        test(false, true);

        /*
         输出:
            g() 0
            g() 1
            f() 0
            g() 2
            g() 3
            g() 4
            f() 1
            f() 2
            f() 3
            f() 4
            *****
            f() 0
            f() 1
            f() 2
            f() 3
            f() 4
            g() 0
            g() 1
            g() 2
            g() 3
            g() 4
        */
    }
}

class DualSynch {

    ConcurrentLinkedQueue<String> trace = new ConcurrentLinkedQueue<>();

    // 通过对整个方法进行同步; this 上进行了同步控制
    public synchronized void f(boolean nap) {
        for (int i = 0; i < 5; i++) {
            trace.add(String.format("f() " + i));
            if (nap) new Nap(0.01);
        }
    }

    private Object syncObj = new Object();

    // 使用了 syncObject 上进行同步的 synchronized 控制块
    public void g(boolean nap) {
        synchronized (syncObj) {
            for (int i = 0; i < 5; i++) {
                trace.add(String.format("g() " + i));
                if (nap) new Nap(0.01);
            }
        }
    }
}


