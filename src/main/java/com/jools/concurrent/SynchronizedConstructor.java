package com.jools.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Jools He
 * @date 2025/6/19 21:26
 * @description: TODO
 */
public class SynchronizedConstructor {

    public static void main(String[] args) {
        SyncFactory instance = SyncFactory.getFactoryInstance(new Unsafe());
    }
}

final class SyncFactory implements HasID {

    private final int id;

    private SyncFactory(ShareArg arg) {
        id = arg.get();
    }

    @Override
    public int getID() {
        return id;
    }

    public static synchronized SyncFactory getFactoryInstance(ShareArg arg) {
        return new SyncFactory(arg);
    }
}

interface ShareArg {
    int get();
}

class Safe implements ShareArg {

    private static AtomicInteger counter = new AtomicInteger(0);

    @Override
    public int get() {
        return counter.getAndIncrement();
    }
}

class Unsafe implements ShareArg {

    private int i = 0;

    @Override
    public int get() {
        return i++;
    }
}

class SyncConstructor implements HasID {

    private final int id;
    private static Object constructorLock = new Object();

    public SyncConstructor(ShareArg arg) {
        synchronized (constructorLock) {
            id = arg.get();
        }
    }

    @Override
    public int getID() {
        return 0;
    }
}