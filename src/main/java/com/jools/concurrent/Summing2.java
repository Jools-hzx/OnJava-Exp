package com.jools.concurrent;

import java.util.Arrays;
import java.util.function.LongSupplier;

/**
 * @author Jools He
 * @date 2025/6/18 15:53
 * @description: TODO
 */
public class Summing2 {

    static long basicSum(long[] ia) {
        long sum = 0;
        int size = ia.length;
        for (int i = 0; i < size; i++) {
            sum += ia[i];
        }
        return sum;
    }

    static void timeTest(String id, long checkValue, LongSupplier operation) {
        System.out.print(id + ": ");
        long start = System.currentTimeMillis();
        long result = operation.getAsLong();
//        if (result == checkValue) {
        System.out.println((System.currentTimeMillis() - start) + " ms ");
//        } else {
//            System.out.format("result: %d%ncheckValue: %d%n", result, checkValue);
//        }
    }

    static final int SZ = 20_000_000;

    public static final long CHECK = (long) SZ * ((long) SZ + 1) / 2;

    public static void main(String[] args) {
        System.out.println(CHECK);

        long[] la = new long[SZ + 1];    // 使用数组的基本类型 long 来填充

        Arrays.setAll(la, i -> i);

        timeTest("Array Sum Stream", CHECK,
                () -> Arrays.stream(la).sum());

        timeTest("Parallel", CHECK,
                () -> Arrays.stream(la)
                        .parallel()
                        .sum());

        timeTest("Sum Iterated", CHECK, () -> basicSum(la));

        // 破坏性求和
        timeTest("Sum Iterated", CHECK, () -> {
            Arrays.parallelPrefix(la, Long::sum);   // 一次累加 0 ~ i 位置并且记录到 i 位置
            return la[la.length - 1];
        });
    }
}
