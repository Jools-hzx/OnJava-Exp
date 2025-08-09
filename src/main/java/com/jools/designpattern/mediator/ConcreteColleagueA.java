package com.jools.designpattern.mediator;

/**
 * @author Jools He
 * @date 2025/7/29 1:01
 * @description: TODO
 */
public class ConcreteColleagueA extends Colleague{

    public ConcreteColleagueA(Mediator mediator) {
        super(mediator);
    }

    // 示意方法，执行某些业务功能
    public void someOperation() {
        // 在需要跟其他同事通信的时候，通知中介者对象
        getMediator().changed(this);
    }
}
