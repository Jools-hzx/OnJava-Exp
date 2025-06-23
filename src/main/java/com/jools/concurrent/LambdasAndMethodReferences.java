package com.jools.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Jools He
 * @date 2025/6/18 17:54
 * @description: TODO
 */
public class LambdasAndMethodReferences {
    public static void main(String[] args) {

        ExecutorService exec = Executors.newCachedThreadPool();

        // 直接传入 Runnable 接口的实现类 [基于 Lambda 表达式]
        exec.submit(() -> System.out.println("Lambda formation"));

        // 传入结构一致的 NotRunnable 及其 Runnable 匿名内部类
        exec.submit(new NotRunnable()::go);
        exec.submit(() -> {
            System.out.println("Lambda formation 2");
            return 1;
        });

        // 传入结构一致的 NotCallable
        exec.submit(new NotCallable()::get);

        // 所有的 submit() 调用都会返回 Future; 可以替换为 execute()
        exec.shutdownNow();
    }
}

class NotRunnable {

    public void go() {
        System.out.println("NotRunnable");
    }
}

class NotCallable {
    public Integer get() {
        System.out.println("NotCallable");
        return 1;
    }
}

