package com.jools.designpattern.decorate;

import java.util.Date;

/**
 * @author Jools He
 * @date 2025/7/27 23:17
 * @description: TODO
 */
public abstract class Component {

    /**
     * 计算某人某段时间内的奖金，有些参数在演示的过程中并不会使用
     * 实际业务是会使用的，为了表示这是个具体的业务方法
     *
     * @param user
     * @param begin
     * @param end
     * @return
     */
    public abstract double calPrize(String user, Date begin, Date end);
}
