package com.jools.generic_;

import com.google.errorprone.annotations.Var;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Random;
import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;
import java.util.function.LongSupplier;
import java.util.function.Supplier;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/21 17:14
 * @description: TODO
 */
public class PrimitiveGenericTest {


    public static void main(String[] args) {

        // 自动根据数组类型填入元素生成数组
        String[] fill = FillArray.fill(new String[5], () -> "s" + new Random().nextInt(100));
        System.out.println(Arrays.toString(fill));  // 输出: [s73, s25, s87, s45, s94]

        int[] intFilled = FillArray.fill(new int[9], () -> 1 + new Random().nextInt(11111));
        System.out.println(Arrays.toString(intFilled)); // 输出: [6965, 2168, 8361, 10064, 8362, 1034, 9212, 4582, 9376]
    }
}

// 数组生成器生产接口
interface FillArray {

    static <T> T[] fill(T[] a, Supplier<T> gen) {
        Arrays.setAll(a, n -> gen.get());
        return a;
    }

    static int[] fill(int[] a, IntSupplier gen) {
        Arrays.setAll(a, n -> gen.getAsInt());
        return a;
    }

    static long[] fill(long[] a, LongSupplier gen) {
        Arrays.setAll(a, n -> gen.getAsLong());
        return a;
    }

    static double[] fill(double[] a, DoubleSupplier gen) {
        Arrays.setAll(a, n -> gen.getAsDouble());
        return a;
    }
}