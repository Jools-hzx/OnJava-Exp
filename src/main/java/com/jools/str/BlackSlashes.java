package com.jools.str;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/8 18:00
 * @description: TODO
 */
public class BlackSlashes {
    public static void main(String[] args) {
        String one = "\\";
        String two = "\\\\";
        String three = "\\\\\\";
        System.out.println(one);
        System.out.println(two);
        System.out.println(three);
        System.out.println(one.matches("\\\\"));
        System.out.println(two.matches("\\\\\\\\"));
        System.out.println(three.matches("\\\\\\\\\\\\"));
        /*
         输出:
            \
            \\
            \\\
            true
            true
            true
        */
    }
}
