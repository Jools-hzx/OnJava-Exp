package com.jools.enum_;

import java.util.stream.IntStream;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/5/1 17:05
 * @description: TODO
 */
public class ArrowInSwitch {

    static void colons(int i) {
        switch (i) {
            case 1:
                System.out.println("one");
                break;
            case 2:
                System.out.println("two");
                break;
            case 3:
                System.out.println("three");
                break;
            default:
                System.out.println("default");
        }
    }

    static void arrows(int i) {
        switch (i) {
            case 1 -> System.out.println("one");
            case 2 -> System.out.println("two");
            case 3 -> System.out.println("three");
            default -> System.out.println("default");
        }
    }

    public static void main(String[] args) {
        IntStream.range(0, 5)
                .forEach(i -> colons(i));
        IntStream.range(0, 5)
                .forEach(i -> arrows(i));
        /*
         输出结果:
            default
            one
            two
            three
            default
            default
            one
            two
            three
            default
        */
    }
}
