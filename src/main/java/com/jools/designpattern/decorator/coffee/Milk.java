package com.jools.designpattern.decorator.coffee;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/2/4 13:45
 * @description: TODO
 */
public class Milk extends CondimentDecorator{

    public Milk(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return 1 + beverage.cost();
    }
}
