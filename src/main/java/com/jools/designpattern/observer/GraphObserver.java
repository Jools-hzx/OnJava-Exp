package com.jools.designpattern.observer;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/1/18 17:26
 * @description: TODO
 */
public class GraphObserver implements Observer {
    @Override
    public void update(NumberGenerator numberGenerator) {
        System.out.println(this.getClass().getSimpleName() + ":" + "\n ==== ");
        int cnt = numberGenerator.getNumber();
        for (int i = 0; i < cnt; i++) {
            System.out.print("***");
        }
        System.out.println("\n=======");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
    }
}
