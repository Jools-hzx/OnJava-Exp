package com.jools.generic_;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.rmi.server.RemoteRef;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/22 17:42
 * @description: TODO
 */

class MixinProxy implements InvocationHandler {

    // 存储调用方法名所在的类实例的映射
    Map<String, Object> delegatesByMethod;

    // 初始化 Map
    MixinProxy(Tuple2<Object, Class<?>>... pairs) {
        delegatesByMethod = new HashMap<>();
        for (Tuple2<Object, Class<?>> pair : pairs) {
            for (Method method : pair.a2.getMethods()) {
                String methodName = method.getName();
                // map 中第一个接口实现了该方法
                if (!delegatesByMethod.containsKey(methodName)) {
                    delegatesByMethod.put(methodName, pair.a1);
                }
            }
        }
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String name = method.getName();         // 方法名
        Object delegate = delegatesByMethod.get(name);  // 通过方法名获取到实例后执行方法
        return method.invoke(delegate, args);
    }

    // 实例化返回一个对象
    public static Object newInstance(Tuple2... pairs) {
        Class[] interfaces = new Class[pairs.length];
        for (int i = 0; i < pairs.length; i++) {
            interfaces[i] = (Class) pairs[i].a2;
        }
        ClassLoader cl = pairs[0].a1.getClass().getClassLoader();
        return Proxy.newProxyInstance(cl, interfaces, new MixinProxy(pairs));
    }
}

public class DynamicProxyMixin {

    public static void main(String[] args) {

        Object mixin = MixinProxy.newInstance(
                new Tuple2(new BasicImp(), Basic.class),
                new Tuple2(new TimeStampedImp(), TimeStamped.class),
                new Tuple2(new SerialNumberedImp(), SerialNumbered.class)
        );
        Basic basic = (Basic) mixin;
        TimeStamped timeStamped = (TimeStamped) mixin;
        SerialNumbered serialNumbered = (SerialNumbered) mixin;
        basic.set("Hello");

        System.out.println(basic.get());        // 输出: Hello
        System.out.println(timeStamped.getStamp()); // 输出: 1745315583144
        System.out.println(serialNumbered.getSerialNumber());   // 输出: 1
    }
}
