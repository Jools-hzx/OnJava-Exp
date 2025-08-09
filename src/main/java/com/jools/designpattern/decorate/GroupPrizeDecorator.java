package com.jools.designpattern.decorate;

import java.util.Date;

/**
 * @author Jools He
 * @desc: 装饰器对象, 计算当月团队业务奖金
 */
public class GroupPrizeDecorator extends Decorator {

    public GroupPrizeDecorator(Component c) {
        super(c);
    }

    @Override
    public double calPrize(String user, Date begin, Date end) {
        // 1. 先获取前面运算出来的奖金
        double money = super.calPrize(user, begin, end);
        // 2. 计算当月团队业务奖金，先计算出团队总的业务额度; 然后在乘以 1%
        double group = 0.0;
        for (Double d : TempDB.mapMonthSaleMoney.values()) {
            group += d;
        }
        double prize = group * 0.01;
        System.out.println(user + " 当月团队业务奖金 " + prize);
        return money + prize;
    }
}
