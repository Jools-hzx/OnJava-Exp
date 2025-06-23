package com.jools.enum_;

import java.util.Random;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/29 20:05
 * @description: TODO
 */
public class RoShamBo1 {

    static final int SIZE = 20;
    private static Random rand = new Random(47);

    public static Item newItem() {
        switch (rand.nextInt(3)) {
            default:
            case 0:
                return new Scissors();
            case 1:
                return new Paper();
            case 2:
                return new Rock();
        }
    }

    // 执行比赛
    public static void match(Item a, Item b) {
        System.out.println(a + " vs. " + b + ": " + a.compete(b));
    }

    public static void main(String[] args) {
        for (int i = 0; i < SIZE; i++) {
            match(newItem(), newItem());
        }
        /*
         输出:
            Rock vs. Rock: DRAW
            Paper vs. Rock: WIN
            Paper vs. Rock: WIN
            Paper vs. Rock: WIN
            Scissors vs. Paper: WIN
            Scissors vs. Scissors: DRAW
            Scissors vs. Paper: WIN
            Rock vs. Paper: LOSE
            Paper vs. Paper: DRAW
            Rock vs. Paper: LOSE
            Paper vs. Scissors: LOSE
            Paper vs. Scissors: LOSE
            Rock vs. Scissors: WIN
            Rock vs. Paper: LOSE
            Paper vs. Rock: WIN
            Scissors vs. Paper: WIN
            Paper vs. Scissors: LOSE
            Paper vs. Scissors: LOSE
            Paper vs. Scissors: LOSE
            Paper vs. Scissors: LOSE
        */
    }
}
