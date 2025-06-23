package com.jools.designpattern.strategy.payment;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/2/3 19:07
 * @description: TODO
 */
public class PayContextExtra extends PayContext {

    //银行账号
    private String account = null;

    /**
     * 构造方法，传入待支付工资的员工的银行卡号和具体的支付策略
     *
     * @param userName 被支付工资的人员
     * @param money    应该被支付的金额
     * @param strategy 支付策略
     * @param account  转入的账户
     */
    public PayContextExtra(String userName, double money, PaymentStrategy strategy, String account) {
        super(userName, money, strategy);
        this.account = account;
    }

    public String getAccount() {
        return account;
    }
}
