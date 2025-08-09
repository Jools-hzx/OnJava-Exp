package com.jools.designpattern.singleton;

/**
 * @author Jools He
 * @date 2025/7/25 22:33
 * @description: TODO
 */
public class InnerStaticClassSingleton {

    private InnerStaticClassSingleton() {
    }

    // 当 Singleton 类加载的时候，静态内部类 SingletonHolder 没有被加载进内存
    // 只有当调用 getInstance() 方法从而触发 SingleonHolder 才会被加载
    private static class SingletonHolder {
        private static InnerStaticClassSingleton INSTANCE =
                new InnerStaticClassSingleton();
    }

    public static InnerStaticClassSingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
