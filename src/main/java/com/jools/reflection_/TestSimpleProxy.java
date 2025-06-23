package com.jools.reflection_;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/12 19:56
 * @description: TODO
 */
public class TestSimpleProxy {

    // 执行 If1 实现类
    public static void consume(If1 instance) {
        instance.doSomething();
        instance.somethingElse("bonbo");
    }

    public static void main(String[] args) {
        consume(new RealObject());
        consume(new SimpleProxy(new RealObject()));
        /*
         输出结果:
            doSomething....
            somethingElse ==>bonbo
            Simple Proxy add operations before doSomething()......
            doSomething....
            Simple Proxy add operations before somethingElse().....
            somethingElse ==>bonbo
        */
    }
}

interface If1 {
    void doSomething();

    void somethingElse(String arg);
}

// 代理实现类
class SimpleProxy implements If1 {
    private If1 proxied;

    public SimpleProxy(If1 proxied) {
        this.proxied = proxied;
    }

    @Override
    public void doSomething() {
        System.out.println("Simple Proxy add operations before doSomething()......");
        proxied.doSomething();
    }

    @Override
    public void somethingElse(String arg) {
        System.out.println("Simple Proxy add operations before somethingElse().....");
        proxied.somethingElse(arg);
    }
}

// 简单实现类
class RealObject implements If1 {

    @Override
    public void doSomething() {
        System.out.println("doSomething....");
    }

    @Override
    public void somethingElse(String arg) {
        System.out.println("somethingElse ==>" + arg);
    }
}
