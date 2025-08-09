package com.jools.designpattern.decorate;

import java.util.Date;

/**
 * @author Jools He
 * @description: 基本的实现计算奖金的类，被装饰器装饰的对象
 */
public class ConcreteComponent extends Component {

    // 默认实现，没有奖金
    @Override
    public double calPrize(String user, Date begin, Date end) {
        return 0;
    }
}
