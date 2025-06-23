package com.jools.array;

import java.util.Arrays;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/25 17:24
 * @description: TODO
 */
public class MultiDimWrapperArray {

    public static void main(String[] args) {

        // 自动装箱 int -> Integer
        Integer[][] a = {
                {1, 2, 3},
                {4, 5, 6}
        };

        // 自动装箱: double -> Double
        Double[][] b = {
                {1.0, 2.0, 3.0},
                {4.0, 5.0, 6.0},
                {9.9, 2.3, 6.4}
        };

        String[][] c = {
                {"The", "Quick", "Sly", "Fox"},
                {"Jumped", "Over", "The", "Lazy", "Dog"},
                {"The", "Brown", "Fox", "Jumped", "Over", "The", "Lazy", "Dog"}
        };

        System.out.println(Arrays.deepToString(a));
        System.out.println(Arrays.deepToString(b));
        System.out.println(Arrays.deepToString(c));

        /*
         输出结果:
            [
                [1, 2, 3],
                [4, 5, 6]
            ]
            [
                [1.0, 2.0, 3.0],
                [4.0, 5.0, 6.0],
                [9.9, 2.3, 6.4]
            ]
            [
                [The, Quick, Sly, Fox],
                [Jumped, Over, The, Lazy, Dog],
                [The, Brown, Fox, Jumped, Over, The, Lazy, Dog]
            ]
        */
    }
}
