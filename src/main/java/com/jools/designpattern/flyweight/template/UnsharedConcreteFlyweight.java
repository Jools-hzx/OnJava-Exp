package com.jools.designpattern.flyweight.template;

/**
 * @author Jools He
 * @desc: 不需要共享的 flyweight 对象
 * 通常是将被共享的享元对象作为子节点组合出来的对象
 */
public class UnsharedConcreteFlyweight implements Flyweight{

    private String allState;

    @Override
    public void operate(String extrinsicState) {
        // 具体的功能
    }
}
