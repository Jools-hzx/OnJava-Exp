package com.jools.designpattern.observer;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/1/18 17:25
 * @description: TODO
 */
public class DigitObserver implements Observer {
    @Override
    public void update(NumberGenerator numberGenerator) {
        System.out.println(this.getClass().getSimpleName() + ":" + numberGenerator.getNumber());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
    }
}
