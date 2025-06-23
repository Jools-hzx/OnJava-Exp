package com.jools.concurrent;

import com.jools.annotation_.Test;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * @author Jools He
 * @date 2025/6/19 15:36
 * @description: TODO
 */
public class QuittingTasks {

    public static final int COUNT = 150;

    public static void main(String[] args) {

        ExecutorService es = Executors.newCachedThreadPool();
        List<QuittableTask> tasks = IntStream.range(1, COUNT)
                .mapToObj(QuittableTask::new)
                .peek(es::execute)
                .toList();
        new Nap(1);

        // 设置共享状态变为 false
        tasks.forEach(QuittableTask::quit);
        es.shutdown();
    }

    @Test
    public void switch2completableFuture() {
        List<QuittableTask> tasks = IntStream.range(1, COUNT)
                .mapToObj(QuittableTask::new)
                .toList();

        // 区别: 并没有使用 peek() 来将 QuittableTask 逐个提交给 ExecutorService, 而是在 cFutures 的创建过程中将任务传给
        // CompletableFuture::runAsync
        List<CompletableFuture<Void>> cFutures = tasks.stream()
                .map(CompletableFuture::runAsync)
                .toList();
        new Nap(1);

        tasks.forEach(QuittableTask::quit);
        cFutures.forEach(CompletableFuture::join);  // return the result value when return
    }
}
