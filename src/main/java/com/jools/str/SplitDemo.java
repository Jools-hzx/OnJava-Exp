package com.jools.str;

import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/8 18:47
 * @description: TODO
 */
public class SplitDemo {

    public static void main(String[] args) {
        String s = "This!!unusual use!!of exclamation!!points";
        System.out.println(Arrays.toString(
                Pattern.compile("!!").split(s)
        ));
    }
}
