package com.jools.proxy.dynamicProxy.jdk;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/1/19 23:28
 * @description: TODO
 */
public class Client {

    public static void main(String[] args) {
        System.setProperty("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true");

        ExerciseService exerciseService = new SlowRunServiceImpl();
        exerciseService.run("Jools Wakoo");

        ExerciseService proxy = (ExerciseService) JdkProxyFactory.getProxy(new SlowRunServiceImpl());
        proxy.run("Jools Wakoooooooo!!!!");

        /*
         输出:
         慢跑中.....	Jools Wakoo
         Before Method: 准备锻炼......
         慢跑中.....	Jools Wakoooooooo!!!!
         After Method: 结束锻炼....
         */
    }
}
