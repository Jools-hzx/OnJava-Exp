package com.jools.array;

import java.util.Arrays;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/25 17:16
 * @description: TODO
 */
public class MultidimensionalPrimitiveArray {

    public static void main(String[] args) {

        int[][] a = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println(Arrays.deepToString(a));
        /*
         输出结果:
          [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
        */
    }
}
