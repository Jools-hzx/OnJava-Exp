package com.jools.concurrent;

import lombok.ToString;

import java.util.concurrent.CompletableFuture;

/**
 * @author Jools He
 * @date 2025/6/19 19:25
 * @description: TODO
 */

final class Frosting {

    private Frosting() {
    }

    static CompletableFuture<Frosting> make() {
        new Nap(0.1);
        return CompletableFuture.completedFuture(new Frosting());
    }
}

public class FrostedCake {

    public FrostedCake(Baked baked, Frosting frosting) {
        System.out.println(baked + " " + frosting);
        new Nap(0.1);
    }

    @Override
    public String toString() {
        return "FrostedCake";
    }

    public static void main(String[] args) {
        Baked.batch().forEach(baked -> baked    // 加入调理并且加入黄油入锅烘培
                .thenCombineAsync(
                        Frosting.make(),    // 模拟加糖霜
                        (cake, frosting) -> new FrostedCake(cake, frosting))
                .thenAcceptAsync(System.out::println)
                .join()
        );
    }
}
