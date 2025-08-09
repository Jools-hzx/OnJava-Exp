package com.jools.designpattern.decorate;

import java.util.Date;

/**
 * @author Jools He
 * @des: 计算当月业务奖金
 */
public class MonthPrizeDecorator extends Decorator {

    public MonthPrizeDecorator(Component c) {
        super(c);
    }

    @Override
    public double calPrize(String user, Date begin, Date end) {
        // 1. 先获取前面运算出来的奖金
        double money = super.calPrize(user, begin, end);
        // 2. 然后计算当月业务奖金，按照人员和时间去获取当月业务额度; 然后再乘以 3 %
        double prize = TempDB.mapMonthSaleMoney.get(user) * 0.03;
        System.out.println(user + "当月业务奖金" + prize);
        return money + prize;
    }
}
