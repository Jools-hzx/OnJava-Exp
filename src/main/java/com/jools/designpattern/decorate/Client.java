package com.jools.designpattern.decorate;

/**
 * @author Jools He
 * @date 2025/7/27 23:50
 * @description: TODO
 */
public class Client {

    public static void main(String[] args) {
        // 先创建计算基本奖金的类，这也是被装饰的对象
        Component c1 = new ConcreteComponent();

        // 对计算的基本奖金进行装饰，组合各个装饰
        // 普通业务人员的奖金计算
        MonthPrizeDecorator d1 = new MonthPrizeDecorator(c1);
        SumPrizeDecorator d2 = new SumPrizeDecorator(d1);

        // 注意: 只需要使用最后组合好的对象调用业务方法即可，会依次调用回去
        double zs = d2.calPrize("张三", null, null);
        System.out.println("=======张三应得奖金: " + zs);
        double ls = d2.calPrize("李四", null, null);
        System.out.println("=======李四应该得到的奖金:" + ls);

        // 角色: 业务经理
        GroupPrizeDecorator d3 = new GroupPrizeDecorator(d2);
        double ww = d3.calPrize("王五", null, null);
        System.out.println("========王经理应该得到奖金:" + ww);

        /*
         输出结果:
            张三当月业务奖金300.0
            张三 累计奖金 1000.0
            =======张三应得奖金: 1300.0
            李四当月业务奖金600.0
            李四 累计奖金 1000.0
            =======李四应该得到的奖金:1600.0
            王五当月业务奖金900.0
            王五 累计奖金 1000.0
            王五 当月团队业务奖金 600.0
            ========王经理应该得到奖金:2500.0
        */
    }
}
