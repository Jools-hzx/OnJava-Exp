package com.jools.designpattern.strategy.discount;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/2/3 11:11
 * @description: TODO
 */
public class ChristmasDiscount implements DiscountStrategy{
    @Override
    public void showDiscount() {
        System.out.println("中秋节折扣！！");
    }
}
