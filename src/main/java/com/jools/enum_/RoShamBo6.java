package com.jools.enum_;

import static com.jools.enum_.Outcome.*;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/5/1 16:56
 * @description: TODO
 */
public enum RoShamBo6 implements Competitor<RoShamBo6> {
    PAPER, SCISSORS, ROCK;

    // 基于每个枚举实例的编号下标存储结果
    private static Outcome[][] table = {
            {DRAW, LOSE, WIN},
            {WIN, DRAW, LOSE},
            {LOSE, WIN, DRAW}
    };

    @Override
    public Outcome compete(RoShamBo6 other) {
        return table[this.ordinal()][other.ordinal()];
    }

    public static void main(String[] args) {
        RoShamBo.play(RoShamBo6.class, 5);
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
