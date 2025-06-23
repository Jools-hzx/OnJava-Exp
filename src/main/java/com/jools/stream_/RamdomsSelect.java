package main.java.com.jools.stream_;

import java.util.Random;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/3/31 22:48
 * @description: TODO
 */
public class RamdomsSelect {

    public static void main(String[] args) {
        new Random(47)
                .ints(5, 20)
                .distinct()
                .limit(7)
                .sorted()
                .forEach(System.out::println);
        /*
         输出:
            6
            10
            13
            16
            17
            18
            19
        */
    }
}
