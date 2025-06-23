package com.jools.concurrent;

import java.util.Arrays;

/**
 * @author Jools He
 * @date 2025/6/18 16:17
 * @description: TODO
 */
public class Summing3 {

    static long basicSum(Long[] ia) {
        long sum = 0;
        int size = ia.length;
        for (int i = 0; i < size; i++) {
            sum += ia[i];
        }
        return sum;
    }

    public static final int SZ = 10_000_000;

    public static final long CHECK = ((long) SZ * (SZ - 1)) / 2;

    public static void main(String[] args) {
        System.out.println(CHECK);
        Long[] aL = new Long[SZ + 1];
        Arrays.parallelSetAll(aL, i -> (long) i);


        Summing2.timeTest("Long Array Stream Sum",
                CHECK, () -> basicSum(aL));

        Summing2.timeTest("Long Array Stream Reduce",
                CHECK, () -> Arrays.stream(aL)
                        .reduce(0L, Long::sum));

        Summing2.timeTest("Long Array Parallel Stream Reduce",
                CHECK, () -> Arrays.stream(aL)
                        .parallel()
                        .reduce(0L, Long::sum));

        // 破坏性求和
        Summing2.timeTest("Long Array Stream Parallel Prefix",
                CHECK, () -> {
                    Arrays.parallelPrefix(aL, Long::sum);
                    return aL[aL.length - 1];
                });
        /*
         输出结果:
            49999995000000
            Long Array Stream Sum: 10 ms
            Long Array Stream Reduce: 102 ms
            Long Array Parallel Stream Reduce: 69 ms
            Long Array Stream Parallel Prefix: 250 ms
        */
    }
}
