package main.java.com.jools.stream_;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/3/31 23:28
 * @description: TODO
 */
public class Repeat {

    public static void repeat(int n, Runnable action) {
        IntStream.range(0, n).forEach(i -> action.run());
    }

    static void hi() {
        System.out.println("Hi!!!");
    }

    public static void main(String[] args) {
        repeat(3, () -> System.out.println("Looping!!!"));
        repeat(2, Repeat::hi);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Shutting down...");
        }));

        /*
            Looping!!!
            Looping!!!
            Looping!!!
            Hi!!!
            Hi!!!
         */
    }
}
