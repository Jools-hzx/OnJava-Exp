package com.jools.proxy.dynamicProxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Set;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/1/19 23:40
 * @description: TODO
 */
public class DemoMethodInterceptor implements MethodInterceptor {


    /**
     * @param o           被代理的对象
     * @param method      被拦截的方法
     * @param args        方法参数
     * @param methodProxy 用于调用原始方法
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o,
                            Method method,
                            Object[] args,
                            MethodProxy methodProxy) throws Throwable {
        //调用方法之前，添加自己的操作
        System.out.println("Before Method: 准备锻炼...... \t " + method.getName());
        Object result = methodProxy.invokeSuper(o, args);    // 可以基于 MethodProxy 调用方法
        //调用方法之后，添加自己的操作
        System.out.println("After Method: 结束锻炼.... \t" + method.getName());
        return result;
    }
}
