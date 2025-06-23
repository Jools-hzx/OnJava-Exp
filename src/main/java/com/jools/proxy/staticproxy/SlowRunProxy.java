package com.jools.proxy.staticproxy;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/1/19 23:11
 * @description: TODO
 */
public class SlowRunProxy implements ExerciseService {

    private final ExerciseService exerciseService;

    public SlowRunProxy(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @Override
    public void run(String msg) {
        //调用方法之前，添加操作
        System.out.println("穿上慢跑鞋.....");
        exerciseService.run(msg);
        System.out.println("慢跑结束！！！");
        System.out.println("脱下慢跑鞋.....");
    }
}
