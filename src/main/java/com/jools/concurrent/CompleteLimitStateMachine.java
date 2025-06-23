package com.jools.concurrent;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author Jools He
 * @date 2025/6/19 15:58
 * @description: TODO
 */
public class CompleteLimitStateMachine {

    public static void main(String[] args) {

        // completeFuture() 创建了一个 ⌈ 已完成 ⌋ 的 CompletableFuture, 这种 future 唯一能够做的失去就是 get() 内部对象
        CompletableFuture<LimitStateMachine> cf = CompletableFuture.completedFuture(new LimitStateMachine(0));

        try {
            // 会阻塞正在等待结果的被调用线程。该阻塞可以通过 InterruptedException 或者 ExecutionException 来中断
            LimitStateMachine stateMachine = cf.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }


        // 借助 CompletableFuture 上增加操作来控制其包含的对象
        CompletableFuture<LimitStateMachine> cfMachine
                = CompletableFuture.completedFuture(new LimitStateMachine(0));
        CompletableFuture<LimitStateMachine> next =
                cfMachine.thenApply(LimitStateMachine::work);   // 输出: LimitStateMachine [id=0 : ONT]
        next = next.thenApply(LimitStateMachine::work);         // 输出: LimitStateMachine [id=0 : TWO]
        next = next.thenApply(LimitStateMachine::work);         // 输出: LimitStateMachine [id=0 : THREE]
        next = next.thenApply(LimitStateMachine::work);         // 输出: LimitStateMachine [id=0 : complete!]
    }


    @Test
    public void removeIntervalVar() {
        long start = System.currentTimeMillis();
        CompletableFuture<LimitStateMachine> cdf = CompletableFuture
                .completedFuture(new LimitStateMachine(0))
                .thenApply(LimitStateMachine::work)
                .thenApply(LimitStateMachine::work)
                .thenApply(LimitStateMachine::work)
                .thenApply(LimitStateMachine::work);
        System.out.println("Duration: " + (System.currentTimeMillis() - start) + "ms");
    }
}
