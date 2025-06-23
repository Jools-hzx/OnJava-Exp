package com.jools.str;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/8 18:18
 * @description: TODO
 */
public class Rudolph {

    public static void main(String[] args) {
        for (String pattern : new String[]{
                "Rudolph",
                "[rR]udolph",
                "[rR][aeiou][a-z]ol.*",
                "R.*"
        }) {
            System.out.println("Rudolph".matches(pattern));
        }
    }
}
