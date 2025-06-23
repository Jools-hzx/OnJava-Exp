package com.jools.proxy.dynamicProxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Random;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/1/19 23:25
 * @description: TODO
 */
public class ExerciseInvocationHandler implements InvocationHandler {

    //代理类代理的目标对象
    private final Object target;

    public ExerciseInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //调用方法之前，添加自己的操作
        System.out.println("Before Method: 准备锻炼......");
        Object result = method.invoke(target, args);
        //调用方法之后，添加自己的操作
        System.out.println("After Method: 结束锻炼....");
        return result;
    }
}
