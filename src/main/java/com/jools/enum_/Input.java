package com.jools.enum_;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.Random;

public enum Input {
    NICKEL(5), DIME(10), QUARTER(25), DOLLAR(100),
    TOOTHPASTE(200), CHIPS(75), SODA(100), SOAP(50),
    ABORT_TRANSACTION {
        @Override
        int amount() {
            // 不允许泛化价格
            throw new RuntimeException("ABORT.amount()");
        }
    },
    STOP {
        @Override
        int amount() {
            throw new RuntimeException("STOP.amount()");
        }
    };


    int value;  // 价格 美分 cent

    Input(int val) {
        this.value = val;
    }

    Input() {
    }

    // 获取价格
    int amount() {
        return value;
    }

    static Random random = new Random(47);

    // 随机返回
    public static Input randomSelection() {
        // 返回不包括的 STOP 的任意
        return values()[random.nextInt(values().length - 1)];
    }
}
