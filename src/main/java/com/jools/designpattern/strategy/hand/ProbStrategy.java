package com.jools.designpattern.strategy.hand;

import java.util.Random;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/2/3 15:44
 * @description: TODO
 */
public class ProbStrategy implements Strategy {

    private Random random;
    private int preHandValue = 0;
    private int currentHandValue;

    //初始默认，各个出拳情况的获胜次数和获胜概率一致
    private int[][] history = {
            {1, 1, 1},
            {1, 1, 1},
            {1, 1, 1}
    };

    public ProbStrategy(int seed) {
        this.random = new Random(seed);
    }

    private int getSum(int hv) {
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += history[hv][i];
        }
        return sum;
    }

    @Override
    public Hand nextHand() {
        int cnt = random.nextInt(getSum(currentHandValue));
        int handValue = 0;
        if (cnt < history[currentHandValue][0]) {   // 小于出拳头比例
            handValue = 0;
        } else if (cnt < history[currentHandValue][0] + history[currentHandValue][1]) { // 小于出剪刀比例
            handValue = 1;
        } else {    // 小于出布的比例
            handValue = 2;
        }
        preHandValue = currentHandValue;    //记录上一个手势
        currentHandValue = handValue;   //更新当前手势
        return Hand.getHand(handValue);
    }

    @Override
    public void study(boolean win) {
        if (win) {
            // 当前获胜，上一局出 preHandValue 本局出 currentHandValue 的获胜场次 + 1
            history[preHandValue][currentHandValue]++;
        } else {
            // 否则,上一局出其余两个手势不战败的获胜场次 + 1
            history[preHandValue][(currentHandValue + 1) % 3]++;
            history[preHandValue][(currentHandValue + 2) % 3]++;
        }
    }
}
