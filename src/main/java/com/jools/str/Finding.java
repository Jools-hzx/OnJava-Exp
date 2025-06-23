package com.jools.str;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/8 18:30
 * @description: TODO
 */
public class Finding {

    public static void main(String[] args) {
        Pattern.compile("\\s+", Pattern.CASE_INSENSITIVE);
        Matcher m = Pattern.compile("\\w+").matcher("Evening is full of the linnet's wings");
        // 会将输入的字符串拆分成为单词
        while (m.find()) {
            System.out.print(m.group() + " ");
        }
        System.out.println();
        int i = 0;
        //接受一个整数参数，指定开始搜索字符的位置
        while (m.find(i)) {
            System.out.print(m.group() + " ");
            i++;
        }
    }
}
