package com.jools.concurrent;

import java.util.concurrent.CompletableFuture;

/**
 * @author Jools He
 * @date 2025/6/19 19:44
 * @description: TODO
 */
public class CompletableExceptions {
    public static void main(String[] args) {
        test("A", 1);
        test("B", 2);

        // 异常不会显式，直到调用
        try {
            test("C", 3).join();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // 测试异常 Returns true if this CompletableFuture completed exceptionally, in any way
        System.out.println(test("G", 2).isCompletedExceptionally());

        // 算作 "完成" Returns true if completed in any fashion: normally, exceptionally, or via cancellation
        System.out.println(test("H", 1).isDone());
    }

    static CompletableFuture<Breakable> test(String id, int failCount) {
        return CompletableFuture.completedFuture(
                        new Breakable(id, failCount))
                .thenApply(Breakable::work)
                .thenApply(Breakable::work)
                .thenApply(Breakable::work)
                .thenApply(Breakable::work);
    }
}


class Breakable {

    String id;

    private int failCount = 0;

    public Breakable(String id, int failCount) {
        this.id = id;
        this.failCount = failCount;
    }

    @Override
    public String toString() {
        return "Breakable{id=" + id +
                "\tcnt=" + failCount +
                '}';
    }

    public static Breakable work(Breakable b) {
        if (--b.failCount == 0) {
            System.out.println("Throwing Exception for " + b.id);
            throw new RuntimeException("Breakable_" + b.id + " failed");
        }
        System.out.println(b);
        return b;
    }
}