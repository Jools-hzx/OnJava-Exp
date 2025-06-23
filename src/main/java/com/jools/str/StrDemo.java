package com.jools.str;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/1/15 21:59
 * @description: TODO
 */
public class StrDemo {

    public static void main(String[] args) {

        String s = "sdfafdsa";
        System.out.println(s.contains(String.valueOf('c')));

        String string = String.format("0.4%s", "2");
        System.out.println(string);
    }
}
