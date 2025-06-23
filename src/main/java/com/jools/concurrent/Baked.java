package com.jools.concurrent;

import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

/**
 * @author Jools He
 * @date 2025/6/19 19:20
 * @description: TODO
 */
public class Baked {

    static class Pan {
    }

    // 将黄油添加进平底锅 Pan
    static Pan pan(Batter b) {
        new Nap(0.1);
        return new Pan();
    }

    // 烘培，入参平底锅 Pan
    static Baked baked(Pan p) {
        new Nap(0.1);
        return new Baked();
    }

    // 构建 CompletableFuture<Baked>
    static CompletableFuture<Baked> bake(CompletableFuture<Batter> cfb) {
        return cfb.thenApplyAsync(Baked::pan)   // 转换为 CompletableFuture<Pan>: 将黄油入锅
                .thenApplyAsync(Baked::baked);  // 转换为 CompletableFuture<Baked>: 平底锅开始烘培
    }

    // 批量
    public static Stream<CompletableFuture<Baked>> batch() {
        CompletableFuture<Batter> batter = Batter.mix();
        return Stream.of(bake(batter), bake(batter),
                bake(batter), bake(batter));
    }
}
