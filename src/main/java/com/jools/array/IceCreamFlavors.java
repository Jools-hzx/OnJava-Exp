package com.jools.array;

import java.util.SplittableRandom;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/25 17:10
 * @description: TODO
 */
public class IceCreamFlavors {

    private static SplittableRandom rand = new SplittableRandom(47);
    private static final String[] FLAVORS = {
            "Chocolate", "Strawberry", "Vanilla Fudge Swirl",
            "Mint Chip", "Mocha Almond Fudge", "Rum Raisin",
            "Praline Cream", "Mud Pie"
    };

    public static String[] flavorSet(int n) {
        if (n > FLAVORS.length) {
            throw new IllegalArgumentException("Set too big");
        }
        String[] result = new String[n];
        boolean[] picked = new boolean[FLAVORS.length];
        for (int i = 0; i < n; i++) {
            int t;
            do {
                t = rand.nextInt(FLAVORS.length);
            } while (picked[t]);
            result[i] = FLAVORS[t];
            picked[t] = true;
        }
        return result;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 7; i++) {
            ArrayShow.show(flavorSet(3));
            /*
             执行结果:
                [Praline Cream, Mint Chip, Vanilla Fudge Swirl]
                [Strawberry, Vanilla Fudge Swirl, Mud Pie]
                [Chocolate, Strawberry, Vanilla Fudge Swirl]
                [Rum Raisin, Praline Cream, Chocolate]
                [Mint Chip, Rum Raisin, Mocha Almond Fudge]
                [Mocha Almond Fudge, Mud Pie, Vanilla Fudge Swirl]
                [Mocha Almond Fudge, Mud Pie, Mint Chip]
            */
        }
    }
}
