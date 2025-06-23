package com.jools.designpattern.statemachine;

import com.jools.concurrent.Nap;

import java.util.Arrays;
import java.util.Iterator;

/**
 * @author Jools He
 * @date 2025/6/22 16:49
 * @description: TODO
 */
public class StateMachineDemo {

    public static void main(String[] args) {
        StateMachine stateMachine = new Washer();
        stateMachine.runAll();

        /*
         输出:
            Washing...
            Spinning...
            Rinsing...
            Spinning...
        */
    }
}

interface State {
    void run();
}

// 状态机抽象类
abstract class StateMachine {

    protected State currState;

    protected abstract boolean changeState();

    // 模板方法; protected 限制仅能由子类调用； 而 changeState() 是抽象方法，由子类实现
    protected final void runAll() {
        while (changeState()) {
            currState.run();
        }
    }
}

// 为每种状态实现一个不同的子类
class Wash implements State {

    @Override
    public void run() {
        System.out.println("Washing...");
        new Nap(0.5);
    }
}

class Spin implements State {

    @Override
    public void run() {
        System.out.println("Spinning...");
        new Nap(0.5);
    }
}

class Rinse implements State {

    @Override
    public void run() {
        System.out.println("Rinsing...");
        new Nap(0.5);
    }
}

// 状态机具体实现
class Washer extends StateMachine {

    private int i = 0;

    private Iterator<State> states =
            Arrays.asList(new Wash(), new Spin(),
                            new Rinse(), new Spin())
                    .iterator();

    @Override
    protected boolean changeState() {
        if (!states.hasNext()) {
            return false;
        }
        // 将代理引用指向一个新的 State 对象
        currState = states.next();
        return true;
    }
}