package com.jools.concurrent;

import java.util.concurrent.CompletableFuture;

/**
 * @author Jools He
 * @date 2025/6/19 17:21
 * @description: TODO
 */
public class Workable {

    String id;
    final double duration;

    public Workable(double duration, String id) {
        this.duration = duration;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Workable[" +
                "id='" + id +
                ']';
    }

    public static Workable work(Workable w) {
        new Nap(w.duration);
        w.id = w.id + "W";
        System.out.println(w);
        return w;
    }

    public static CompletableFuture<Workable> make(String id, double duration) {
        // java.util.concurrent.CompletionStage
        // Returns a new CompletionStage that, when this stage completes normally, is executed using this stage's default asynchronous execution
        return CompletableFuture.completedFuture(
                new Workable(duration, id)
        ).thenApplyAsync(Workable::work);
    }
}
