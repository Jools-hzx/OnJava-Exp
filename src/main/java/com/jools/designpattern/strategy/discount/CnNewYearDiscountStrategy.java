package com.jools.designpattern.strategy.discount;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/2/3 11:08
 * @description: TODO
 */
public class CnNewYearDiscountStrategy implements DiscountStrategy {
    @Override
    public void showDiscount() {
        System.out.println("春节折扣！！");
    }
}
