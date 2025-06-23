package com.jools.designpattern.observer;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/1/18 18:40
 * @description: TODO
 */
public class DotObserver implements Observer{
    @Override
    public void update(NumberGenerator numberGenerator) {
        int number = numberGenerator.getNumber();
        System.out.println(this.getClass().getSimpleName() + ":" + "\n====");
        for (int i = 0; i < number; i++) {
            System.out.print(". \t");
        }
        System.out.println("\n========");
    }
}
