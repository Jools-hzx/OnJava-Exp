package com.jools.concurrent;

import org.checkerframework.checker.units.qual.C;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author Jools He
 * @date 2025/6/19 16:34
 * @description: TODO
 */
public class CompletableUtilities {

    public static void showr(CompletableFuture<?> cf) {
        try {
            System.out.println(cf.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    // 针对无值的 CF 操作
    public static void voidr(CompletableFuture<?> cf) {
        try {
            cf.get();   // 返回 void
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
