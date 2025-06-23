package com.jools.reflection;

import com.jools.reflection_.A;

import java.lang.reflect.InvocationTargetException;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/13 23:55
 * @description: TODO
 */
public class AnonymousA {

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        A a = AnonymousA.createA();
        a.f();

        // 输出匿名内部类
        System.out.println(a.getClass().getName());

        // 但是通过反射依然可以调用
        HiddenImplementation.callHiddenMethod(a, "u");
        HiddenImplementation.callHiddenMethod(a, "v");
        HiddenImplementation.callHiddenMethod(a, "w");
        HiddenImplementation.callHiddenMethod(a, "g");
    }

    public static A createA() {
        return new A() {
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
        };
    }
}
