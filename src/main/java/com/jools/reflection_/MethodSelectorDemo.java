package com.jools.reflection_;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/12 20:30
 * @description: TODO
 */
public class MethodSelectorDemo {

    public static void main(String[] args) {
        SomeMethods someMethodsProxy = ((SomeMethods) Proxy.newProxyInstance(
                SomeMethods.class.getClassLoader(),
                new Class[]{SomeMethods.class},
                new MethodSelector(new Implementation())));
        someMethodsProxy.boring1();
        someMethodsProxy.boring2();
        someMethodsProxy.interesting("This is very interesting!!!!!!!");
        someMethodsProxy.boring3();
        /*
         输出:
            Insert operations before Proxy invoke()!!!
            boring....
            Insert operations before Proxy invoke()!!!
            boring....
            Proxy detected target method, Method Name ->interesting
            Insert operations before Proxy invoke()!!!
            interesting....This is very interesting!!!!!!!
            Insert operations before Proxy invoke()!!!
            boring3.....
        */
    }
}

class MethodSelector implements InvocationHandler {

    private Object obj;

    public MethodSelector(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.getName().equals("interesting")) {
            System.out.println("Proxy detected target method, Method Name ->" + method.getName());
        }
        System.out.println("Insert operations before Proxy invoke()!!!");
        return method.invoke(obj, args);
    }
}

interface SomeMethods {
    void boring1();
    void boring2();
    void interesting(String arg);
    void boring3();
}

class Implementation implements SomeMethods {

    @Override
    public void boring1() {
        System.out.println("boring....");
    }

    @Override
    public void boring2() {
        System.out.println("boring....");
    }

    @Override
    public void interesting(String arg) {
        System.out.println("interesting...." + arg);
    }

    @Override
    public void boring3() {
        System.out.println("boring3.....");
    }
}
