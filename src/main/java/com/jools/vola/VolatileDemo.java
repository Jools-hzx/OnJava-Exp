package com.jools.vola;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/1/30 21:37
 * @description: TODO
 */
public class VolatileDemo {

    volatile static int cnt = 0;

    public static void incr() {
        cnt++;
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            threadPool.execute(() -> {
                for (int j = 0; j < 100; j++) {
                    VolatileDemo.incr();
                }
            });
        }
        Thread.sleep(1000);
        System.out.println(cnt);        // 理论上应该是: 5 * 100 = 500; 但是存在输出小于 500 的情况，比如:453
        threadPool.shutdown();
    }
}
