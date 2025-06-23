package com.jools.concurrent;

import java.util.concurrent.CompletableFuture;

/**
 * @author Jools He
 * @date 2025/6/19 16:36
 * @description: TODO
 */
public class CompletableOperations {

    static CompletableFuture<Integer> cfi(int i) {
        return CompletableFuture.completedFuture(
                i
        );
    }

    public static void main(String[] args) {

        CompletableUtilities.showr(cfi(1));     // 输出: 1

        // thenRunAsync
        CompletableUtilities.voidr(cfi(2).thenRunAsync(
                () -> System.out.println("thenRunAsync")
        ));                                     // 输出: thenRunAsync

        // static 静态 runAsync 方法
        CompletableUtilities.voidr(
                CompletableFuture.runAsync(
                        () -> System.out.println("runAsync static method")
                )
        );                                      // 输出: runAsync static method

        CompletableUtilities.showr(
                CompletableFuture.supplyAsync(
                        () -> 99
                )
        );                                      // 输出: 99

        // accept single input and return no result
        CompletableUtilities.voidr(
                cfi(4).thenAcceptAsync(
                        i -> System.out.println("thenAcceptAsync: " + i)
                )
        );                                                      // 输出: thenAcceptAsync: 4

        CompletableUtilities.showr(
                cfi(5).thenApplyAsync(
                        i -> i + 42
                )
        );                                                      // 输出: 47

        CompletableUtilities.showr(
                cfi(6).thenComposeAsync(
                        i -> cfi(i + 99)                // 输出: 105
                )
        );

        CompletableFuture<Integer> c = cfi(7);
        c.obtrudeValue(111);  // Forcibly sets or resets the value subsequently returned by method get() and related methods, whether or not already completed.
        CompletableUtilities.showr(c);                                  // 输出: 111
        CompletableUtilities.showr(cfi(8).toCompletableFuture());       // 输出: 8

        c = new CompletableFuture<>();
        c.complete(9); // If not already completed, sets the value returned by get() and related methods to the given value.
        CompletableUtilities.showr(c);

        c = new CompletableFuture<>();
        c.cancel(true);
        System.out.println("cancelled:" + c.isCancelled());     // 输出: cancelled: true

        System.out.println("Completed exceptionally:" +         // 输出: Completed exceptionally:true
                c.isCompletedExceptionally()
        );

        System.out.println("done: " + c.isDone());              // 输出: done: true
        System.out.println(c);

        c = new CompletableFuture<>();
        // getNow(): Returns the result value (or throws any encountered exception) if completed, else returns the given valueIfAbsent.
        System.out.println(c.getNow(777));          // 输出: 777

        c = new CompletableFuture<>();
        c.thenApplyAsync(i -> i + 42)
                .thenApplyAsync(i -> i + 99);

        // getNumberOfDependents():
        // Returns the estimated number of CompletableFutures whose
        // completions are awaiting completion of this CompletableFuture.
        System.out.println("dependents: " +
                c.getNumberOfDependents());     // 输出: dependents: 1
        c.thenApplyAsync(i -> i / 2);

        System.out.println("dependents: " +     // 输出: dependents: 2
                c.getNumberOfDependents());
    }
}
