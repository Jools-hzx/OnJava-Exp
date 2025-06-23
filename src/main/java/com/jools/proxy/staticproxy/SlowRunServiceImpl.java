package com.jools.proxy.staticproxy;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/1/19 23:10
 * @description: TODO
 */
public class SlowRunServiceImpl implements ExerciseService{
    @Override
    public void run(String msg) {
        System.out.println("慢跑中....." + "\t" + msg);
    }
}
