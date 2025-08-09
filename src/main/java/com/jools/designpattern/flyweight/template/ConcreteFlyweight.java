package com.jools.designpattern.flyweight.template;

/**
 * @author Jools He
 * @description: 享元对象
 */
public class ConcreteFlyweight implements Flyweight{

    private String intrinsicState;

    public ConcreteFlyweight(String state) {
        this.intrinsicState = state;
    }

    @Override
    public void operate(String extrinsicState) {
        // 具体的功能处理，可能会用到享元内部、外部的状态
    }
}
