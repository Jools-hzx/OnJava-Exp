package com.jools.pat;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/2/7 12:50
 * @description: TODO
 */
public class Pat1034Demo {

    public static void main(String[] args) {
        String s1 = "2/3";
        String s2 = "-4/2";


        String s3 = "5/3";
        String s4 = "0/6";

        System.out.println(getSimplify(s1));
        System.out.println(getSimplify(s2));
        System.out.println(getSimplify(s3));
        System.out.println(getSimplify(s4));

        Map<Integer, String> map = new HashMap<>();
    }

    /*
     乘法运算:
     1. 判断乘法和被乘数是否还有负号:
        a. 两个都为负数则返回正数；两个都为正数则也返回正数
        b. 其中一个为负号则返回正数
     2. 分子之间相乘
     3. 分母之间相乘
     4. 计算正数 k = 分子 / 分母；
     5. 最终结果为 k (分子 - k * 分母) / 分母
     */
    private static String multi(String n1, String n2) {
        // 判断乘数和被乘数是否含有负号
        boolean isN1Negative = n1.contains("-") ? true : false;
        boolean isN2Negative = n2.contains("-") ? true : false;

        // 获取两个乘数的分子部分
        String fzN1 = "", fzN2 = "";
        String fmN1 = "", fmN2 = "";

        if (n1.contains("/")) {
            fzN1 = n1.substring(0, n1.indexOf("/"));
            fmN1 = n1.substring(n1.indexOf("/") + 1);
        } else {
            if (isN1Negative) {
                fzN1 = n1.substring(n1.indexOf("-") + 1);
            } else {
                fzN1 = n1;
            }
        }

        if (n2.contains("/")) {
            fzN1 = n2.substring(0, n2.indexOf("/"));
            fmN1 = n2.substring(n2.indexOf("/") + 1);
        } else {
            if (isN2Negative) {
                fzN2 = n2.substring(n2.indexOf("-") + 1);
            } else {
                fzN2 = n2;
            }
        }

        //分子相乘
        int resFz = Integer.valueOf(fzN1) * Integer.valueOf(fzN2);
        //分母相乘
        int resFm = 0;
        if (!fmN1.isEmpty() && !fmN2.isEmpty()) {
            resFm = Integer.valueOf(fmN1) * Integer.valueOf(fmN2);
        } else {
            resFm = fmN1.isEmpty() ? Integer.valueOf(fmN2) : Integer.valueOf(fmN1);
        }

        return null;
    }

    /**
     * 将分数化简为最简形式
     *
     * @param input 输入的分数，格式为 "分子/分母"
     * @return 化简后的分数，格式为 "整数 分子/分母" 或 "分子/分母"
     */
    static String getSimplify(String input) {
        // 使用 StringBuilder 来构建结果字符串
        StringBuilder sb = new StringBuilder();

        // 检查输入是否为负数
        if (input.indexOf("-") != -1) {
            // 如果是负数，添加负号到结果字符串
            sb.append("-");
            // 去除负号，继续处理剩余部分
            input = input.substring(1, input.length());
        }

        // 提取分子
        String fenZi = input.substring(0, input.indexOf("/"));
        // 提取分母
        String fenMu = input.substring(input.indexOf("/") + 1);

        // 特殊情况：分子为0
        if (fenZi.equals("0")) {
            // 直接返回 "0"
            return sb.append("0").toString();
        }

        // 将分子和分母转换为整数
        int fzInt = Integer.valueOf(fenZi);
        int fmInt = Integer.valueOf(fenMu);

        // 计算整数部分 k
        int k = fzInt / fmInt;
        // 计算分子的余数
        fzInt = k > 0 ? fzInt - (k * fmInt) : fzInt;

        // 如果有整数部分，添加到结果字符串
        if (k > 0) {
            sb.append(k).append(" ");
        }

        // 如果分子整除分母，直接返回结果
        if (fzInt == 0) {
            return sb.toString();
        }

        // 拼接分子和分母到结果字符串
        sb.append(fzInt).append("/").append(fmInt);

        // 返回结果字符串
        return sb.toString();
    }
}


