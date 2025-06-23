package com.jools.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/25 21:39
 * @description: TODO
 */
public class ParallelPrefix2 {

    public static void main(String[] args) {

        String[] strings = {"Hello", "World", "Jools He"};
        ArrayShow.show("Not using prefix", strings);
        Arrays.parallelPrefix(strings, (a, b) -> a + b);
        ArrayShow.show("Using prefix", strings);

        /*
         输出结果:
            Not using prefix:
            [Hello, World, Jools He]
            Using prefix:
            [Hello, HelloWorld, HelloWorldJools He]
        */
    }
}
