package main.java.com.jools.stream_;

import java.util.Arrays;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/2 16:50
 * @description: TODO
 */
public class Peeking {

    public static void main(String[] args) {

        Arrays.stream(new int[]{1, 2, 3, 4})
                .peek(System.out::print)
                .map(i -> i * i)
                .peek(System.out::print)
                .map(i -> i - (3))
                .peek(System.out::print)
                .forEach(System.out::print);

    }
}
