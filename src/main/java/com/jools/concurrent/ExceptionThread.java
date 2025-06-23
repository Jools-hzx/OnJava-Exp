package com.jools.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Jools He
 * @date 2025/6/20 15:41
 * @description: TODO
 */
public class ExceptionThread implements Runnable {
    @Override
    public void run() {
        throw new RuntimeException();
    }

    public static void main(String[] args) {

        ExecutorService es = Executors.newCachedThreadPool();
        try {
            es.execute(new ExceptionThread());
        } catch (Exception e) {
            System.out.println("Caught Exception");
        } finally {
            es.shutdown();
        }
    }
}
