package com.jools.designpattern.state;

/**
 * @author Jools He
 * @date 2025/6/22 16:15
 * @description: TODO
 */
public class StateDemo {

    static void test(State s) {
        s.f();
        s.g();
        s.h();
    }

    public static void main(String[] args) {
        State s = new State(new Implementation1());
        test(s);                            // 调用状态1的方法 (Implementation1)
        System.out.println("Chnage Implementation (Change State impl)");
        s.change(new Implementation2());    // 切换为状态2 (Implementation2)
        test(s);                            // 调用状态2的方法 (Implementation2)
    }
}

class State {

    private State implementation;

    protected State() {
    }

    public State(State impl) {
        this.implementation = impl;
    }

    public void change(State newImpl) {
        this.implementation = newImpl;
    }

    // 将方法调用转发到实现类
    public void f() {
        implementation.f();
    }

    public void g() {
        implementation.g();
    }

    public void h() {
        implementation.h();
    }
}

class Implementation1 extends State {

    @Override
    public void f() {
        System.out.println("Implementation1 f()");
    }

    @Override
    public void g() {
        System.out.println("Implementation1 g()");
    }

    @Override
    public void h() {
        System.out.println("Implementation1 h()");
    }
}

class Implementation2 extends State {

    @Override
    public void f() {
        System.out.println("Implementation2 f()");
    }

    @Override
    public void g() {
        System.out.println("Implementation2 g()");
    }

    @Override
    public void h() {
        System.out.println("Implementation2 h()");
    }
}

