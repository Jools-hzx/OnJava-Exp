package com.jools.concurrent;

import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

/**
 * @author Jools He
 * @date 2025/6/19 20:30
 * @description: TODO
 */
public class ThrowsChecked {

    class Checked extends Exception {
    }

    static ThrowsChecked noChecked(ThrowsChecked tc) {
        return tc;
    }

    static ThrowsChecked withChecked(ThrowsChecked tc) throws Checked {
        return tc;
    }

    static void testStream() {
        Stream.of(new ThrowsChecked())
                .map(ThrowsChecked::noChecked)
//                .map(ThrowsChecked::withChecked)     使用 withChecked 的方法引用 报错
                .map(tc -> {
                    try {
                        return withChecked(tc);
                    } catch (Checked e) {
                        throw new RuntimeException(e);
                    }
                });
    }

    static void testCompletableFuture() {
        CompletableFuture.completedFuture(new ThrowsChecked())
                .thenApply(ThrowsChecked::noChecked)
//                .thenApply(ThrowsChecked::withChecked)    使用 withChecked 的方法引用 报错
                .thenApply(tc -> {
                    try {
                        return withChecked(tc);
                    } catch (Checked e) {
                        throw new RuntimeException(e);
                    }
                });
    }
}
