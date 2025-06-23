package com.jools.designpattern.proxy_;

/**
 * @author Jools He
 * @date 2025/6/22 16:08
 * @description: TODO
 */
public class ProxyDemo {

    public static void main(String[] args) {
        Proxy p = new Proxy();
        p.f();
        p.g();
        p.h();

        /*
         输出结果:
            Implementation.f()
            Implementation.g()
            Implementation.h()
        */
    }
}

interface ProxyBase {

    void f();

    void g();

    void h();
}

// 代理类
class Proxy implements ProxyBase {

    private ProxyBase impl = new Implementation();

    @Override
    public void f() {
        impl.f();
    }

    @Override
    public void g() {
        impl.g();
    }

    @Override
    public void h() {
        impl.h();
    }
}

// 实现类
class Implementation implements ProxyBase {

    @Override
    public void f() {
        System.out.println("Implementation.f()");
    }

    @Override
    public void g() {
        System.out.println("Implementation.g()");
    }

    @Override
    public void h() {
        System.out.println("Implementation.h()");
    }
}