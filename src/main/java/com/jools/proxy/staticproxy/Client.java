package com.jools.proxy.staticproxy;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/1/19 23:13
 * @description: TODO
 */
public class Client {

    public static void main(String[] args) {

        ExerciseService exerciseService = new SlowRunServiceImpl();
        exerciseService.run("Jools Wakoo");

        ExerciseService serviceProxy = new SlowRunProxy(new SlowRunServiceImpl());
        serviceProxy.run("Jools Wakoo !!!!");

        /*
        输出:
        慢跑中.....	Jools Wakoo           //exerciseService 输出
        穿上慢跑鞋.....                     //proxy 输出
        慢跑中.....	Jools Wakoo !!!!
        慢跑结束！！！
        脱下慢跑鞋.....
         */
    }
}
