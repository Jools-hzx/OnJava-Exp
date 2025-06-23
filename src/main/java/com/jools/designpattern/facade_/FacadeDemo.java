package com.jools.designpattern.facade_;

/**
 * @author Jools He
 * @date 2025/6/22 23:58
 * @description: TODO
 */
public class FacadeDemo {

    static A makeA(int x) {
        return new A(x);
    }

    static B makeB(int x) {
        return new B(x);
    }

    static C makeC(double x) {
        return new C(x);
    }

    public static void main(String[] args) {
        // 通过调用静态方法得到对象
        FacadeDemo.makeA(1);
        FacadeDemo.makeB(1);
        FacadeDemo.makeC(1.1);
    }
}

class A {
    A(int x) {
    }
}

class B {
    B(long x) {
    }
}

class C {
    C(double x) {
    }
}
