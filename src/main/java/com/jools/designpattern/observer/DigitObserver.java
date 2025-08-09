package com.jools.designpattern.observer;

/**
 * @author Jools He
 * @date 2025/7/29 11:31
 * @description: TODO
 */
public class DigitObserver implements Observer{

    @Override
    public void update(NumberGenerator generator) {
        System.out.println("DigitObserver:" + generator.getNumber());
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
