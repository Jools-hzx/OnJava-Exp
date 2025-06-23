package com.jools.designpattern.strategy.payment;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/2/3 18:59
 * @description: TODO
 */
public class DollarCash implements PaymentStrategy {
    @Override
    public void pay(PayContext payContext) {
        System.out.println("给" + payContext.getUserName() + " 美元现金支付: " + payContext.getMoney());
    }
}
