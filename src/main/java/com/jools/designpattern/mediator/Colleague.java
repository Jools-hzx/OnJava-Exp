package com.jools.designpattern.mediator;

/**
 * @author Jools He
 * @description: 同事类的抽象父类
 */
public abstract class Colleague {

    /**
     * 持有中介对象
     */
    private Mediator mediator;

    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }

    public Mediator getMediator() {
        return mediator;
    }
}
