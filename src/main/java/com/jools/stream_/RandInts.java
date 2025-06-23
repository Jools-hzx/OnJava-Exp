package main.java.com.jools.stream_;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/3 0:09
 * @description: TODO
 */
public class RandInts {

    private static int[] ints
            = new Random(47)
            .ints(0, 1000)
            .limit(100)
            .toArray();

    public static IntStream rands() {
        return Arrays.stream(ints);
    }
}
