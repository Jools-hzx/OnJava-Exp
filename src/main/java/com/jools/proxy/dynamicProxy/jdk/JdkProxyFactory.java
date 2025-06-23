package com.jools.proxy.dynamicProxy.jdk;

import java.lang.reflect.Proxy;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/1/19 23:27
 * @description: TODO
 */
public class JdkProxyFactory {

    public static Object getProxy(Object target) {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new ExerciseInvocationHandler(target)
        );
    }
}
