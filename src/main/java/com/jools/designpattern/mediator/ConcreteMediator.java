package com.jools.designpattern.mediator;

/**
 * @author Jools He
 * @date 2025/7/29 1:06
 * @description: TODO
 */
public class ConcreteMediator implements Mediator{

    /**
     * 持有并维护同事 A
     */
    private ConcreteColleagueA colleagueA;
    /**
     * 持有并维护同事 B
     */
    private ConcreteColleagueB colleagueB;

    // 设置中介者需要了解并且维护的同事 A 对象
    public void setConcreteColleagueA(ConcreteColleagueA colleagueA) {
        this.colleagueA = colleagueA;
    }

    // 设置中介者需要了解并且维护的同事 B 对象
    public void setConcreteColleagueB(ConcreteColleagueB colleagueB) {
        this.colleagueB = colleagueB;
    }

    @Override
    public void changed(Colleague colleague) {
        // 某个同事发生了变化，需要与其他同事进行交互
        // 具体协调相应的同事来实现
    }
}
