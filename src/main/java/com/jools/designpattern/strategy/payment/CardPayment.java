package com.jools.designpattern.strategy.payment;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/2/3 19:11
 * @description: TODO
 */
public class CardPayment implements PaymentStrategy {
    @Override
    public void pay(PayContext payContext) {
        // 获取账户
        PayContextExtra contextExtra = (PayContextExtra) payContext;
        System.out.println("不使用现金，给" + contextExtra.getUserName() +
                " 转账" + contextExtra.getMoney() +
                " 到账户:" + contextExtra.getAccount());
    }
}
