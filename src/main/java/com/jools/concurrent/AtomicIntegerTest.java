package com.jools.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Jools He
 * @date 2025/6/20 17:28
 * @description: TODO
 */
public class AtomicIntegerTest extends IntTestable {

    private AtomicInteger i = new AtomicInteger(0);

    @Override
    void evenIncrement() {
        i.addAndGet(2); // 累加并获取
    }

    @Override
    public int getAsInt() {
        return i.get();
    }
}
