package com.jools.designpattern.observer;

import java.util.Random;

/**
 * @author Jools He
 * @date 2025/7/29 11:29
 * @description: TODO
 */
public class RandomNumberGenerator extends NumberGenerator {

    private Random random = new Random();

    private int number;

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public void execute() {
        for (int i = 0; i < 20; i++) {
            number = random.nextInt(50);
            notifyObservers();
        }
    }
}
