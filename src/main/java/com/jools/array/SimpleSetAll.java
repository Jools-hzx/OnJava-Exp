package com.jools.array;

import java.util.Arrays;
import java.util.function.IntFunction;
import java.util.stream.Stream;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/25 17:48
 * @description: TODO
 */
public class SimpleSetAll {

    public static final int SZ = 8;
    static int val = 1;
    static char[] chars = "sdfafsfasfsanvjlrjoi".toCharArray();

    static char getChar(int n) {
        return chars[n];
    }

    public static void main(String[] args) {

        int[] ia = new int[SZ];
        long[] la = new long[SZ];
        double[] da = new double[SZ];

        // 直接把数组索引作为值插入
        Arrays.setAll(ia, n -> n);
        Arrays.setAll(la, n -> n);
        Arrays.setAll(da, n -> n);

        ArrayShow.show(ia);
        ArrayShow.show(la);
        ArrayShow.show(da);

        // 只需要接收索引参数，生成相应结果
        Arrays.setAll(ia, n -> val++);
        Arrays.setAll(la, n -> val++);
        Arrays.setAll(da, n -> val++);

        ArrayShow.show(ia);
        ArrayShow.show(la);
        ArrayShow.show(da);

        // 方法引用有效; 因为 Bob 的构造器接收 int 类型参数。只要我们传入的函数
        // 能够接收 int 类型参数并且生成预期的结果
        Bob[] bobArr = new Bob[SZ];
        Arrays.setAll(bobArr, Bob::new);

        Character[] ca = new Character[SZ];
        // getChar() 方法参数列表与 IntFunction 接口的 apply() 方法参数列表相同
        Arrays.setAll(ca, SimpleSetAll::getChar);
        ArrayShow.show(ca);

        /*
         输出结果:
            [0, 1, 2, 3, 4, 5, 6, 7]
            [0, 1, 2, 3, 4, 5, 6, 7]
            [0.0, 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0]
            [1, 2, 3, 4, 5, 6, 7, 8]
            [9, 10, 11, 12, 13, 14, 15, 16]
            [17.0, 18.0, 19.0, 20.0, 21.0, 22.0, 23.0, 24.0]
            [s, d, f, a, f, s, f, a]
        */

        Integer[] array = Stream.generate(() -> 1)
                .limit(5)
                .toArray(Integer[]::new);
        ArrayShow.show(array);  // 输出: [1, 1, 1, 1, 1]
    }
}

class Bob {

    final int id;

    Bob(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Bob{" +
                "id=" + id +
                '}';
    }
}