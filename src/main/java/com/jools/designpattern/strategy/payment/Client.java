package com.jools.designpattern.strategy.payment;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/2/3 18:59
 * @description: TODO
 */
public class Client {

    public static void main(String[] args) {

        RMBCash strategyRMB = new RMBCash();
        DollarCash strategyDollar = new DollarCash();
        CardPayment cardPayment = new CardPayment();

        //准备员工信息上下文
        PayContext context = new PayContext("Jools wakoo", 5000, strategyRMB);
        //支付
        context.payNow();

        // 切换员工
        PayContext context02 = new PayContext("Jooools", 10000, strategyDollar);
        // 给第二位员工
        context02.payNow();


        // 支付到银行卡
        PayContext payContext = new PayContextExtra("Wakkkkoooo", 11111, cardPayment, "12345678999");
        payContext.payNow();

        /*
         输出:
            给 Jools wakoo 支付人名币:5000.0
            给 Jooools 美元现金支付: 10000.0
            不使用现金，给 Wakkkkoooo 转账 11111.0 到账户:12345678999
        */
    }
}
