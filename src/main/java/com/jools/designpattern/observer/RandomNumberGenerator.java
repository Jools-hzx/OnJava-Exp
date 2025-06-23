package com.jools.designpattern.observer;

import java.util.Random;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/1/18 17:22
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
        for (int i = 0; i < 5; i++) {
            number = random.nextInt(20);
            super.notifyAllObservers();     // 通知所有监听者
        }
    }
}
