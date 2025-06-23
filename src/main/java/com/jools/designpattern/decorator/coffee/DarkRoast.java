package com.jools.designpattern.decorator.coffee;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/2/4 13:43
 * @description: TODO
 */
public class DarkRoast implements Beverage{
    @Override
    public double cost() {
        return 1;
    }
}
