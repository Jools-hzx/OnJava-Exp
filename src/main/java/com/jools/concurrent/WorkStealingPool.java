package com.jools.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author Jools He
 * @date 2025/6/20 15:33
 * @description: TODO
 */
public class WorkStealingPool {

    public static void main(String[] args) throws InterruptedException {

        // 查询当前机器的处理器数目
        System.out.println(Runtime.getRuntime().availableProcessors());     // 输出: 20
        ExecutorService exec = Executors.newWorkStealingPool(); // 创建一个工作窃取线程池

        IntStream.range(0, 10)
                .mapToObj(n -> new ShowThread())
                .forEach(exec::execute);

        /*
        awaitTermination():
        Blocks until all tasks have completed execution after a shutdown request,
        or the timeout occurs, or the current thread is interrupted, whichever happens first.
        */
        exec.awaitTermination(1, TimeUnit.SECONDS);
    }
}


class ShowThread implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}