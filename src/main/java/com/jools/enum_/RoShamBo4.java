package com.jools.enum_;


/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/29 22:36
 * @description: TODO
 */
public enum RoShamBo4 implements Competitor<RoShamBo4> {

    ROCK {
        @Override
        public Outcome compete(RoShamBo4 competitor) {
            return compete(SCISSORS, competitor);
        }
    },
    SCISSORS {
        @Override
        public Outcome compete(RoShamBo4 competitor) {
            return compete(PAPER, competitor);
        }
    },
    PAPER {
        @Override
        public Outcome compete(RoShamBo4 competitor) {
            return compete(ROCK, competitor);
        }
    };

    // 相同枚举实例，打平; 如果传入的为获胜枚举实例，返回 WIN 否则为 LOSE
    public Outcome compete(RoShamBo4 loser, RoShamBo4 oppoent) {
        return ((oppoent == this) ? Outcome.DRAW : ((oppoent == loser)) ?
                Outcome.WIN : Outcome.LOSE);
    }

    public static void main(String[] args) {
        RoShamBo.play(RoShamBo4.class, 5);
        /*
         输出结果:
            PAPER vs. PAPER: DRAW
            SCISSORS vs. PAPER: WIN
            SCISSORS vs. PAPER: WIN
            SCISSORS vs. PAPER: WIN
            ROCK vs. SCISSORS: WIN
        */
    }
}
