package com.jools.designpattern.respchain;

/**
 * @author Jools He
 * @description: 问题类
 *
 */
public class Trouble {

    // 问题编号
    private int number;

    public Trouble(int number) {
        this.number = number;
    }

    // 获取问题编号
    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "[ Trouble - " + number +
                ']';
    }
}
