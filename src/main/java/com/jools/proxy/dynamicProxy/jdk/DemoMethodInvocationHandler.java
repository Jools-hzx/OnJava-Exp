package com.jools.proxy.dynamicProxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/1/20 10:48
 * @description: TODO
 */
public class DemoMethodInvocationHandler implements InvocationHandler {

    private final Object target;

    public DemoMethodInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Pre-handle method");
        method.setAccessible(true);
        Object result = method.invoke(target, args);
        method.setAccessible(false);
        return result;
    }
}
