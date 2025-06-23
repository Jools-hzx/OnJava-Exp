package com.jools.concurrent;

import java.util.concurrent.Callable;

/**
 * @author Jools He
 * @date 2025/6/18 17:15
 * @description: TODO
 */
public class CountingTask implements Callable<Integer> {

    final int id;

    public CountingTask(int id) {
        this.id = id;
    }

    /**
     call() 完全独立地生成结果；独立于任何其他的 CountingTask
     */
    @Override
    public Integer call() {
        int val = 0;
        for (int i = 0; i < 100; i++) {
            val++;
        }
        System.out.println(id + " " +
                Thread.currentThread().getName()
                + " " + val);
        return val;
    }
}
