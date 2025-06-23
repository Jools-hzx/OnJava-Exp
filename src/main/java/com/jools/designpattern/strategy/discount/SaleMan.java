package com.jools.designpattern.strategy.discount;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/2/3 11:12
 * @description: TODO
 */
public class SaleMan {

    private DiscountStrategy strategy;

    public SaleMan() {
    }

    public void displaySaleManStrategy() {
        strategy.showDiscount();
    }

    public void setStrategy(DiscountStrategy strategy) {
        this.strategy = strategy;
    }
}
