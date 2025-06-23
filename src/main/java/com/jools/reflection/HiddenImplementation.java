package com.jools.reflection;

import com.jools.reflection_.A;
import com.jools.reflection_.HiddenC;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/13 23:42
 * @description: TODO
 */
public class HiddenImplementation {

    static void callHiddenMethod(Object a, String methodName) throws
            NoSuchMethodException,
            InvocationTargetException,
            IllegalAccessException {
        Method method = a.getClass().getDeclaredMethod(methodName);
        method.setAccessible(true);
        // 反射调用方法
        method.invoke(a);
    }

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        // A 为 public, 因此可以包外访问
        A a = HiddenC.makeAImplC();
        a.f();
        System.out.println(a.getClass().getName());

        // 包外无法访问符号 'C'
//        if(a instanceof C) {
//            C c = (C) a;
//            c.g();
//        }

        // 但是可以通过反射爆破访问方法
        callHiddenMethod(a, "g");
        callHiddenMethod(a, "u");
        callHiddenMethod(a, "v");
        callHiddenMethod(a, "w");

        /*
         输出:
            public C.f()
            com.jools.reflection_.C
            public C.g()
            protected u()
            private C.v()
            package C.u()
        */
    }
}
