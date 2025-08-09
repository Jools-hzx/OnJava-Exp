package com.jools.designpattern.decorate;

import java.util.Date;

/**
 * @author Jools He
 * @desc: 计算累计奖金
 */
public class SumPrizeDecorator extends Decorator {

    public SumPrizeDecorator(Component c) {
        super(c);
    }

    @Override
    public double calPrize(String user, Date begin, Date end) {
        // 1. 先获取已经计算得到的奖金
        double money = super.calPrize(user, begin, end);
        // 2. 计算累计奖金，按照人员去获取累计的业务额度，然后乘以 0.1%
        double prize = 1000000 * 0.001;
        System.out.println(user + " 累计奖金 " + prize);
        return money + prize;
    }
}
