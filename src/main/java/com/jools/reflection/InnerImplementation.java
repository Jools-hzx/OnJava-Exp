package com.jools.reflection;

import com.jools.reflection_.A;

import java.lang.reflect.InvocationTargetException;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/13 23:50
 * @description: TODO
 */
public class InnerImplementation {

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        A a = InnerA.createA();
        a.f();
        System.out.println(a.getClass().getName()); // 输出内部类

        // 但是通过反射依然可以调用
        HiddenImplementation.callHiddenMethod(a, "u");
        HiddenImplementation.callHiddenMethod(a, "v");
        HiddenImplementation.callHiddenMethod(a, "w");
        HiddenImplementation.callHiddenMethod(a, "g");
    }
}

class InnerA {

    // 返回 A 内部实现类
    public static A createA() {
        return new C();
    }

    private static class C implements A {

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
}
