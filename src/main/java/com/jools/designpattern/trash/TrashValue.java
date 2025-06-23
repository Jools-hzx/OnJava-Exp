package com.jools.designpattern.trash;

import java.util.List;

/**
 * @author Jools He
 * @date 2025/6/23 2:35
 * @description: TODO
 */
public class TrashValue {

    private static double total;

    public static void sum(List<? extends Trash> bin, String type) {
        total = 0.0;
        bin.forEach(t -> {
            System.out.println(t);
            total += t.weight * t.price();
        });
        System.out.printf(
                "Total %s value = %.2f%n", type, total);
    }
}
