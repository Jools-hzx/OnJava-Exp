package com.jools.designpattern.observer;

/**
 * @author Jools He
 * @date 2025/7/29 11:32
 * @description: TODO
 */
public class GraphObserver implements Observer{

    @Override
    public void update(NumberGenerator generator) {
        System.out.println("Graph Observer");
        int count = generator.getNumber();
        for (int i = 0; i < count; i++) {
            System.out.print("*");
        }
        System.out.println();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
