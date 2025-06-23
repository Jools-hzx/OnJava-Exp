package com.jools.designpattern.strategy.hand;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/2/3 12:06
 * @description: TODO
 */
public class Hand {

    public static final int HANDVALUE_GUU = 0;  // 表示石头
    public static final int HANDVALUE_CHO = 1;  // 表示剪刀
    public static final int HANDVALUE_PAA = 2;  // 表示布

    public static final String[] names = {
            "石头", "剪刀", "布"
    };

    public static final Hand[] hand = {
            new Hand(HANDVALUE_GUU),    // 0 对应石头
            new Hand(HANDVALUE_CHO),    // 1 对应剪刀
            new Hand(HANDVALUE_PAA),    // 2 对应布
    };

    private int handValue;

    public Hand(int handValue) {
        this.handValue = handValue;
    }

    // 根据手势的值获取其对应的实例
    public static Hand getHand(int handValue) {
        return hand[handValue];
    }

    public boolean isStrongerThan(Hand thatHand) {
        return (this.handValue + 1) % 3 == thatHand.handValue;
    }

    // 表示两个手势的比较结果
    private int fight(Hand thatHand) {
        if (this == thatHand) {
            return 0;   // 单例模式，直接比较地址；相等则打平
        } else if (isStrongerThan(thatHand)) {
            return 1;   // 获胜
        } else {
            return -1;  // 战败
        }
    }

    @Override
    public String toString() {
        return String.valueOf(this.handValue);
    }
}
