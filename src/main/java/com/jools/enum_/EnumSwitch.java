package com.jools.enum_;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/5/1 17:51
 * @description: TODO
 */
public class EnumSwitch {

    enum Signal {
        GREEN, YELLOW, RED, BLUE
    }

    Signal color = Signal.RED;

    public void changeLight() {
        //'switch' expression does not cover all possible input values
        color = switch (color) {
            case RED -> Signal.GREEN;
            case YELLOW -> Signal.RED;
            case GREEN, BLUE -> Signal.YELLOW;
        };
    }
}
