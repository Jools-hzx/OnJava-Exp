package com.jools.array;

import java.util.Arrays;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/25 20:50
 * @description: TODO
 */
public class StreamFromArray {

    public static void main(String[] args) {

        Integer[] array = new RandGen.Integer().array(10);
        Arrays.stream(array)
                .skip(3)
                .limit(5)
                .map(ss -> ss + " ~~~!!! ")
                .forEach(s -> System.out.print(s + " "));
        System.out.println();

        int[] ia = new RandGen.Pint().array(10);
        Arrays.stream(ia)
                .skip(3)
                .limit(5)
                .map(i -> i * 10)
                .forEach(s -> System.out.print(s + " "));

        // 只能支持 int、long 以及 double; 对于其他类型需要实用包装类
        Arrays.stream(new long[10]);
        Arrays.stream(new double[10]);
        Arrays.stream(new Float[10]);

//        Arrays.stream(new char[10]);    // 报错

        Integer[] arr2 = new RandGen.Integer().array(10);
        Arrays.stream(ConvertTo.primitive(arr2));
    }
}
