package com.jools.designpattern.strategy.payment;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/2/3 18:55
 * @description: TODO
 */
public class PayContext {

    // 被支付工资的人员
    private String userName = null;

    // 应该被支付的工资金额
    private double money = 0.0;

    // 支付工资的方式策略接口
    private PaymentStrategy strategy = null;

    public PayContext(String userName, double money, PaymentStrategy strategy) {
        this.userName = userName;
        this.money = money;
        this.strategy = strategy;
    }

    public String getUserName() {
        return userName;
    }

    public double getMoney() {
        return money;
    }

    public void payNow() {
        this.strategy.pay(this);
    }
}
