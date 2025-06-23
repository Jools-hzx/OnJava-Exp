package com.jools.designpattern.strategy.discount;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/2/3 11:14
 * @description: TODO
 */
public class Client {

    public static void main(String[] args) {

        SaleMan context = new SaleMan();

        System.out.print("春节:");
        context.setStrategy(new CnNewYearDiscountStrategy());
        context.displaySaleManStrategy();

        System.out.print("中秋节:");
        context.setStrategy(new MidAutumnDiscount());
        context.displaySaleManStrategy();

        System.out.print("圣诞节:");
        context.setStrategy(new ChristmasDiscount());
        context.displaySaleManStrategy();

        /*
         输出:
            春节:春节折扣！！
            中秋节:中秋节折扣！！！！
            圣诞节:中秋节折扣！！
        */
    }
}
