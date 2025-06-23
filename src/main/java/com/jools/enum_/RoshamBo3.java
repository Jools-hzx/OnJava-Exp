package com.jools.enum_;

import static com.jools.enum_.RoShamBo2.ROCK;
import static com.jools.enum_.RoShamBo2.SCISSORS;

public enum RoshamBo3 implements Competitor<RoshamBo3>{
    PAPER {
        @Override
        public Outcome compete(RoshamBo3 it) {

            switch (it) {
                default:
                case PAPER:
                    return Outcome.DRAW;
                case SCISSORS:
                    return Outcome.LOSE;
                case ROCK:
                    return Outcome.WIN;
            }
        }
    },
    SCISSORS {
        @Override
        public Outcome compete(RoshamBo3 it) {
            switch (it) {
                default:
                case PAPER:
                    return Outcome.WIN;
                case SCISSORS:
                    return Outcome.DRAW;
                case ROCK:
                    return Outcome.LOSE;
            }
        }
    },
    ROCK {
        @Override
        public Outcome compete(RoshamBo3 it) {
            switch (it) {
                default:
                case PAPER:
                    return Outcome.LOSE;
                case SCISSORS:
                    return Outcome.WIN;
                case ROCK:
                    return Outcome.DRAW;
            }
        }
    };

    @Override
    public Outcome compete(RoshamBo3 it) {
        return null;
    }
}
