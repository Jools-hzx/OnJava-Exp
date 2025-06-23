package com.jools.str;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/8 17:52
 * @description: TODO
 */
public class Indentation {

    // 无缩进
    public static final String NONE = """
            XXX
            YYY
            """;

    // 缩进 2 个空格
    public static final String TWO = """
              XX
              YY
            """;

    // 缩进 4 个空格
    public static final String FOUR = """
                XX
                YY
            """;

    public static void main(String[] args) {
        System.out.println(NONE);
        System.out.println(TWO);
        System.out.println(FOUR);
    }
}
