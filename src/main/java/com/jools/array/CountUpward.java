package com.jools.array;

import java.util.Arrays;
import java.util.stream.LongStream;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/25 18:50
 * @description: TODO
 */
public class CountUpward {

    static final int SZ = 100_000_000_0;

    static long[] fillCounted(int size) {
        return LongStream
                .iterate(0, i -> i + 1)
                .limit(size)
                .toArray();
    }

    // 优化初始化速度: Arrays.parallelSetAll() 更快地完成初始化
    static void intArray() {
        int[] la = new int[SZ];
        long start = System.currentTimeMillis();
        Arrays.setAll(la, new RandGen.Integer()::get);
        long end = System.currentTimeMillis();
        System.out.println("setAll():" + (end - start));

        start = System.currentTimeMillis();
        Arrays.parallelSetAll(la, new RandGen.Integer()::get);
        end = System.currentTimeMillis();
        System.out.println("parallelSetAll():" + (end - start));
    }

    public static void main(String[] args) {
        long[] l1 = fillCounted(20);    // 通过
        ArrayShow.show(l1);

        long[] l2 = fillCounted(20000);

        intArray();
    }
}
