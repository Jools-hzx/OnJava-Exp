package com.jools.enum_;

import static com.jools.enum_.Outcome.*;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/29 20:16
 * @description: TODO
 */
public enum RoShamBo2 implements Competitor<RoShamBo2> {

    // 直接将枚举实例作为字段；但是需要提前规划好匹配结果
    PAPER(DRAW, LOSE, WIN),
    SCISSORS(WIN, DRAW, LOSE),
    ROCK(LOSE, WIN, DRAW);
    private Outcome vPAPER, vSCISSORS, vROCK;

    RoShamBo2(Outcome paper, Outcome scissors, Outcome rock) {
        this.vPAPER = paper;
        this.vSCISSORS = scissors;
        this.vROCK = rock;
    }

    @Override
    public Outcome compete(RoShamBo2 it) {
        switch (it) {
            case PAPER:
                return vPAPER;
            case SCISSORS:
                return vSCISSORS;
            case ROCK:
                return vROCK;
            default:
                throw new RuntimeException("Unsupported compete type" + it);
        }
    }
}

class RoShamBo {

    public static <T extends Competitor<T>> void match(T a, T b) {
        System.out.println(a + " vs. " + b + ": " + a.compete(b));
    }

    // 基于 Enum 抽象类公共方法遍历所有 RoShamBo2 实例
    public static <T extends Enum<T> & Competitor<T>> void play(Class<T> rsbClass, int size) {
        for (int i = 0; i < size; i++) {
            match(Enums.random(rsbClass), Enums.random(rsbClass));
        }
    }

    public static void main(String[] args) {
        RoShamBo.play(RoShamBo2.class, 5);
        /*
          执行结果:
          ROCK vs. ROCK: DRAW
            SCISSORS vs. ROCK: LOSE
            SCISSORS vs. ROCK: LOSE
            SCISSORS vs. ROCK: LOSE
            PAPER vs. SCISSORS: LOSE
        */
    }
}

interface Competitor<T extends Competitor<T>> {
    Outcome compete(T competitor);
}