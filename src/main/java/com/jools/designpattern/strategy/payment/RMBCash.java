package com.jools.designpattern.strategy.payment;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/2/3 18:57
 * @description: TODO
 */
public class RMBCash implements PaymentStrategy{
    @Override
    public void pay(PayContext payContext) {
        System.out.println("给" + payContext.getUserName() + " 支付人名币:" + payContext.getMoney());
    }
}
