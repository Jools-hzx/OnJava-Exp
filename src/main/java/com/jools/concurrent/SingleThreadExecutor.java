package com.jools.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * @author Jools He
 * @date 2025/6/18 16:54
 * @description: TODO
 */
public class SingleThreadExecutor {

    public static void main(String[] args) {

        // 工厂方法: 创建特定类型的 ExecutorService
        ExecutorService exec = Executors.newSingleThreadExecutor();

        // 创建 10 个 NapTask 并且将它们提交到了 ExecutorService
        IntStream.range(0, 10)
                .mapToObj(NapTask::new)
                .forEach(exec::execute);

        System.out.println("All tasks submitted");

        // 调用 exec.shutdown() 会告诉 ExecutorService 完成所有已提交的任务，不再接受任何新任务
        exec.shutdown();
        while (!exec.isTerminated()) {  // 当所有任务都完成之后，该方法会返回 true
            System.out.println(Thread.currentThread().getName()
                    + " wawiting termination");
            new Nap(0.1);
        }
    }
}
