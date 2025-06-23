package com.jools.concurrent;

import java.util.concurrent.CompletableFuture;

import static com.jools.concurrent.CompletableUtilities.showr;
import static com.jools.concurrent.CompletableUtilities.voidr;

/**
 * @author Jools He
 * @date 2025/6/19 17:28
 * @description: TODO
 */
public class DualCompletableOperations {

    static CompletableFuture<Workable> cfA, cfB;

    static void init() {
        cfA = Workable.make("A", 0.15);
        cfB = Workable.make("B", 0.15);
    }

    static void join() {
        cfA.join();
        cfB.join();
        System.out.println("***************");
    }

    public static void main(String[] args) {
        init();
        voidr(cfA.runAfterEitherAsync(cfB,
                () -> System.out.println("runAfterEither"))
        );
        join();

        /*
         输出:
            Workable[id='BW]
            Workable[id='AW]
            runAfterEither
            ***************
        */


        init();
        voidr(cfA.runAfterBothAsync(cfB,
                () -> System.out.println("runAfterBoth"))
        );
        join();

        /*
         输出:
            Workable[id='AW]
            Workable[id='BW]
            runAfterBoth
        */

        init();
        voidr(cfA.acceptEitherAsync(cfB,
                (w) -> System.out.println("acceptEither: " + w))
        );
        join();

        /*
         输出:
            Workable[id='AW]
            Workable[id='BW]
            acceptEither: Workable[id='AW]
        */

        init();
        voidr(cfA.thenAcceptBothAsync(cfB, (w1, w2) -> {
            System.out.println("thenAcceptBoth: " + w1 + ", " + w2);
        }));
        join();
        /*
         输出:
            Workable[id='BW]
            Workable[id='AW]
            thenAcceptBoth: Workable[id='AW], Workable[id='BW]
        */

        init();
        showr(cfA.thenCombineAsync(cfB, (w1, w2) -> {
            System.out.println("thenCombineAsync: " + w1 + ", " + w2);
            return w1;
        }));
        join();
        /*
         输出:
            Workable[id='AW]
            Workable[id='BW]
            thenCombineAsync: Workable[id='AW], Workable[id='BW]
            Workable[id='AW]
         */

        init();
        CompletableFuture<Workable> cfC = Workable.make("C", 0.05);
        CompletableFuture<Workable> cfD = Workable.make("D", 0.09);
        CompletableFuture
                .anyOf(cfA, cfB, cfC, cfD)
                .thenRunAsync(() -> System.out.println("anyOf(): "));
        join();
        /*
        Workable[id='CW]
        anyOf():
        Workable[id='DW]
        Workable[id='BW]
        Workable[id='AW]
        */

        init();
        cfC = Workable.make("C", 0.08);
        cfD = Workable.make("D", 0.10);
        CompletableFuture
                .allOf(cfA, cfB, cfC, cfD)
                .thenRunAsync(() -> System.out.println("allOf(): "));
        join();
        cfC.join();
        cfD.join();
        /*
         输出:
            Workable[id='CW]
            Workable[id='DW]
            Workable[id='AW]
            Workable[id='BW]
            allOf():
        */
    }
}
