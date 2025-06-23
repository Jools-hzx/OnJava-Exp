package com.jools.str;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/8 18:05
 * @description: TODO
 */
public class IntegerMatch {

    public static void main(String[] args) {
        System.out.println("-1234".matches("-?\\d+"));  // true
        System.out.println("1234".matches("-?\\d+"));   // true
        System.out.println("+911".matches("-?\\d+"));   // false
        System.out.println("+911".matches("([-+])?\\d+"));  // true
    }
}
