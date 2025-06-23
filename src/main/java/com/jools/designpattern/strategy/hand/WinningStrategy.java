package com.jools.designpattern.strategy.hand;

import java.time.Period;
import java.util.Random;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/2/3 12:23
 * @description: TODO
 */
public class WinningStrategy implements Strategy {

    private boolean preIsWin = false;
    private Hand preHand;
    private Random random;

    public WinningStrategy(int seed) {
        this.random = new Random(seed);
    }

    @Override
    public Hand nextHand() {
        if (!preIsWin) {    // 上一轮未获胜，更新随机手势
            this.preHand = Hand.getHand(random.nextInt(3));
            return preHand;
        }
        return preHand;
    }

    @Override
    public void study(boolean win) {
        this.preIsWin = win;
    }
}
