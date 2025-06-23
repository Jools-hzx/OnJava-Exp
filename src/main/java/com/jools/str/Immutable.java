package com.jools.str;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/8 16:16
 * @description: TODO
 */
public class Immutable {

    public static String upcase(String s) {
        return s.toUpperCase();
    }

    public static void main(String[] args) {
        String q = "howdy";
        System.out.println(q);  // howdy
        String qq = upcase(q);
        System.out.println(qq); // HOWDY
        System.out.println(q);  // howdy
    }
}
