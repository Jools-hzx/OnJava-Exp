package com.jools.proxy.dynamicProxy.cglib;

import net.sf.cglib.proxy.CallbackFilter;
import net.sf.cglib.proxy.Enhancer;

import java.lang.reflect.Method;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/1/19 23:44
 * @description: TODO
 */
public class CglibProxyFactory {

    public static Object getProxy(Class<?> clazz) {
        // 创建动态代理增强类
        Enhancer enhancer = new Enhancer();
        // 设置类加载器
        enhancer.setClassLoader(clazz.getClassLoader());
        // 设置被代理类
        enhancer.setSuperclass(clazz);
        //设置方法拦截
        enhancer.setCallback(new DemoMethodInterceptor());
        enhancer.setCallbackFilter(new CallbackFilter() {
            @Override
            public int accept(Method method) {
                return 0;
            }
        });
        //创建代理类
        return enhancer.create();
    }
}
