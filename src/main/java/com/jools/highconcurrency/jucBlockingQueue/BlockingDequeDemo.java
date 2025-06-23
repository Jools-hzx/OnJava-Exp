package com.jools.highconcurrency.jucBlockingQueue;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/1/29 2:26
 * @description: TODO
 */
public class BlockingDequeDemo {

    public static void main(String[] args) {

        BlockingDeque<String> deque = new LinkedBlockingDeque<String>();
        deque.addFirst("1");
        deque.addLast("2");

        try {
            String two = deque.takeLast();
            String one = deque.takeFirst();
            System.out.println(two);
            System.out.println(one);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        /*
         输出:
            2
            1
        */
    }
}
