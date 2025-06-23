package com.jools.reflection_;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/13 23:37
 * @description: TODO
 */
public class HiddenC {

    public static A makeAImplC() {
        return new C();
    }
}

class C implements A {

    @Override
    public void f() {
        System.out.println("public C.f()");
    }

    public void g() {
        System.out.println("public C.g()");
    }

    protected void u() {
        System.out.println("protected u()");
    }

    void w() {
        System.out.println("package C.u()");
    }

    private void v() {
        System.out.println("private C.v()");
    }
}
