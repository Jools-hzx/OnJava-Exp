package com.jools.concurrent;

import java.util.concurrent.TimeUnit;

/**
 * @author Jools He
 * @date 2025/6/18 16:49
 * @description: TODO
 */
public class Nap {

    public Nap(double t) {
        try {
            TimeUnit.MILLISECONDS.sleep((int) (1000 * t));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public Nap(double t, String msg) {
        this(t);
        System.out.println(msg);
    }
}
