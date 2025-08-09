package com.jools.designpattern.builder.str;

/**
 * @author Jools He
 * @date 2025/7/26 23:48
 * @description: TODO
 */
public class Client {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        final int cnt = 26;
        for (int i = 0; i < cnt; i++) {
            sb.append((char) ('a' + i));
        }
        System.out.println(sb);
    }
}
