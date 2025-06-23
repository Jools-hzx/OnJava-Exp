package com.jools.concurrent;

import java.util.concurrent.CompletableFuture;

/**
 * @author Jools He
 * @date 2025/6/19 17:53
 * @description: 模拟制作蛋糕的过程; 第一步是准备配料 (ingredient), 将它们混入到面糊 (batter)
 */
public class Batter {

    static class Eggs { }

    static class Milk { }

    static class Sugar { }

    static class Flour { }

    static <T> T prepare(T ingredient) {
        new Nap(0.1);
        return ingredient;
    }

    static <T> CompletableFuture<T> prep(T ingredient) {
        return CompletableFuture.completedFuture(ingredient)
                .thenApplyAsync(Batter::prepare);
    }

    public static CompletableFuture<Batter> mix() {
        CompletableFuture<Eggs> eggs = prep(new Eggs());
        CompletableFuture<Milk> milk = prep(new Milk());
        CompletableFuture<Sugar> sugar = prep(new Sugar());
        CompletableFuture<Flour> flour = prep(new Flour());
        CompletableFuture
                .allOf(eggs, milk, sugar, flour)
                .join();
        new Nap(0.5);   // 模拟混合的时间
        return CompletableFuture.completedFuture(new Batter());
    }
}
