package com.jools.designpattern.observer;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/1/18 18:23
 * @description: TODO
 */
public class IncrementalNumberGenerator extends NumberGenerator {

    //初始数值
    private int initNum;

    //结束数值
    private int boundNum;

    //递增步长
    private int step;

    private int num;

    public IncrementalNumberGenerator(int initNum, int boundNum, int step) {
        this.initNum = initNum;
        this.boundNum = boundNum;
        this.step = step;
        this.num = initNum;
        if(this.step <= 0 || this.boundNum <= 0) {
            throw new RuntimeException("Initial num cannot be lower than zero!");
        }
    }

    public int getInitNum() {
        return initNum;
    }

    public int getBoundNum() {
        return boundNum;
    }

    public int getStep() {
        return step;
    }

    @Override
    public int getNumber() {
        return num;
    }

    @Override
    public void execute() {
        //不断更新
        while (this.num <= this.boundNum) {
            super.notifyAllObservers();
            if (this.num > this.boundNum) {
                this.num = this.boundNum;
            } else {
                //更新递增步长
                this.num += this.step;
            }
        }
    }
}
