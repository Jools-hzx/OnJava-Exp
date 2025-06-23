package com.jools.str;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/8 18:42
 * @description: TODO
 */
public class ReFlags {

    public static void main(String[] args) {
        Pattern p = Pattern.compile("^java",
                Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);
        Matcher m = p.matcher(
                "java has regex\nJava has regex\n" +
                        "JAVA has pretty good regular expression\n" +
                        "Regular expression are in Java");
        while (m.find()) {
            System.out.println(m.group());
        }
    }
}
