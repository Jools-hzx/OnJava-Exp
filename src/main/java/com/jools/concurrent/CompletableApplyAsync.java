package com.jools.concurrent;

import java.util.concurrent.CompletableFuture;

/**
 * @author Jools He
 * @date 2025/6/19 16:17
 * @description: TODO
 */
public class CompletableApplyAsync {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        CompletableFuture<LimitStateMachine> cf = CompletableFuture.completedFuture(
                        new LimitStateMachine(0)
                ).thenApplyAsync(LimitStateMachine::work)
                .thenApplyAsync(LimitStateMachine::work)
                .thenApplyAsync(LimitStateMachine::work)
                .thenApplyAsync(LimitStateMachine::work);
        long end = System.currentTimeMillis();
        System.out.println("Duration before join(): " + (end - start));
        cf.join();
        System.out.println("Duration after join(): " + (System.currentTimeMillis() - end));

        /*
         输出结果:
            Duration before join(): 0
                LimitStateMachine [id=0 : ONT]
                LimitStateMachine [id=0 : TWO]
                LimitStateMachine [id=0 : THREE]
                LimitStateMachine [id=0 : complete!]
            Duration after join(): 430
        */
    }
}
