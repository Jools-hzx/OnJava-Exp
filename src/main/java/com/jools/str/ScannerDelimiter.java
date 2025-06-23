package com.jools.str;

import java.util.Scanner;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/8 18:57
 * @description: TODO
 */
public class ScannerDelimiter {
    public static void main(String[] args) {

        Scanner s = new Scanner("12, 42, 78, 99, 42")
                .useDelimiter("\\s*,\\s*");
        while (s.hasNextInt()) {
            System.out.println(s.nextInt());
        }
        /*
         输出:
            12
            42
            78
            99
            42
        */
    }
}
