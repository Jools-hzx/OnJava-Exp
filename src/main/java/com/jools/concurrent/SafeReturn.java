package com.jools.concurrent;

import java.util.function.IntSupplier;

/**
 * @author Jools He
 * @date 2025/6/20 16:51
 * @description: TODO
 */
public class SafeReturn {
}

class Atomicity {

    public static void test(IntTestable it) {

    }
}

class UnsafeReturn extends IntTestable {

    private int i = 0;

    @Override
    void evenIncrement() {
        i++;
        i++;
    }

    @Override
    public int getAsInt() {
        return i;
    }
}


abstract class IntTestable implements Runnable, IntSupplier {

    abstract void evenIncrement();

    @Override
    public void run() {
        while (true) {
            evenIncrement();
        }
    }
}