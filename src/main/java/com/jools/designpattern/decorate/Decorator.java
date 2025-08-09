package com.jools.designpattern.decorate;

import java.util.Date;

/**
 * @author Jools He
 * @des: 装饰器的接口，需要跟被装饰的对象实现同样的接口;
 * 这样才能保证装饰之后的对象仍然可以被继续修饰
 */
public abstract class Decorator extends Component {

    protected Component c;

    // 通过构造方法传入被修饰的对象1
    public Decorator(Component c) {
        this.c = c;
    }

    @Override
    public double calPrize(String user, Date begin, Date end) {
        // 转调组件对象的方法
        return c.calPrize(user, begin, end);
    }
}
