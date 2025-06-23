package com.jools.reflection_;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/12 20:13
 * @description: TODO
 */
public class DynamicProxyDemo01 {
}

class DynamicProxyHandler implements InvocationHandler {

    private Object obj;

    public DynamicProxyHandler(Object proxy) {
        this.obj = proxy;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(
                "****** proxy:" + proxy.getClass() +
                        "\nmethod(): " + method +
                        "\nargs:" + Arrays.toString(args));
        return method.invoke(obj, args);
    }
}

class SimpleDynamicProxy {

    public static void consumer(If1 if1) {
        if1.doSomething();
        if1.somethingElse("bonbo");
    }

    public static void main(String[] args) {
        RealObject realObject = new RealObject();
        consumer(realObject);
        // 插入了一个代理然后再次调用
        If1 ifProxy = ((If1) Proxy.newProxyInstance(
                If1.class.getClassLoader(),
                new Class[]{If1.class},
                new DynamicProxyHandler(realObject)
        ));
        consumer(ifProxy);

        /*
         输出结果:
            doSomething....
            somethingElse ==>bonbo
            ****** proxy:class com.jools.reflection_.$Proxy0
            method(): public abstract void com.jools.reflection_.If1.doSomething()
            args:null
            doSomething....
            ****** proxy:class com.jools.reflection_.$Proxy0
            method(): public abstract void com.jools.reflection_.If1.somethingElse(java.lang.String)
            args:[bonbo]
            somethingElse ==>bonbo
        */
    }
}
