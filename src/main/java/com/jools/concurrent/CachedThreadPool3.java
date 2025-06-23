package com.jools.concurrent;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

/**
 * @author Jools He
 * @date 2025/6/18 17:18
 * @description: TODO
 */
public class CachedThreadPool3 {

    // 获取结果
    public static Integer extractResult(Future<Integer> f) {
        try {
            return f.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void simplifyUsingParallel() {
        System.out.println(
                IntStream.range(0, 10)
                        .parallel()
                        .mapToObj(CountingTask::new)
                        .map(c -> c.call())
                        .reduce(0, Integer::sum)
        );
        /*
         输出结果:
            5 ForkJoinPool.commonPool-worker-4 100
            7 ForkJoinPool.commonPool-worker-5 100
            0 ForkJoinPool.commonPool-worker-7 100
            6 main 100
            1 ForkJoinPool.commonPool-worker-2 100
            2 ForkJoinPool.commonPool-worker-1 100
            3 ForkJoinPool.commonPool-worker-9 100
            9 ForkJoinPool.commonPool-worker-8 100
            4 ForkJoinPool.commonPool-worker-6 100
            8 ForkJoinPool.commonPool-worker-3 100
            1000
        */
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();

        // 创建 10 个线程任务
        List<CountingTask> tasks = IntStream.range(0, 10)
                .mapToObj(CountingTask::new)
                .toList();

        // 执行任务
        List<Future<Integer>> futures = exec.invokeAll(tasks);

        // 获取任务执行结果之和
        Integer sum = futures.stream()
                .map(CachedThreadPool3::extractResult)
                .reduce(0, Integer::sum);

        System.out.println("sum = " + sum);
        exec.shutdown();

        /*
         输出结果:
            8 pool-1-thread-9 100
            4 pool-1-thread-5 100
            2 pool-1-thread-3 100
            7 pool-1-thread-8 100
            3 pool-1-thread-4 100
            5 pool-1-thread-6 100
            6 pool-1-thread-7 100
            9 pool-1-thread-10 100
            0 pool-1-thread-1 100
            1 pool-1-thread-2 100
            sum = 1000
        */
    }
}
