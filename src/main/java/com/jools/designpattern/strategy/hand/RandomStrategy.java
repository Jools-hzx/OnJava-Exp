package com.jools.designpattern.strategy.hand;

import java.util.Random;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/2/3 16:36
 * @description: TODO
 */
public class RandomStrategy implements Strategy{

    private Random random;

    public RandomStrategy(int seed) {
        this.random = new Random(seed);
    }

    @Override
    public Hand nextHand() {
        return Hand.getHand(random.nextInt(3));
    }

    @Override
    public void study(boolean win) {
        // Not operate
    }
}
