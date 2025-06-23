package com.jools.pat;

import java.util.Scanner;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/5 17:00
 * @description: TODO
 */
public class Pat1027Demo {

    static String input = "15 43 71";

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        String[] str = s.nextLine().split("\\s+");
        StringBuilder sb = new StringBuilder();
        sb.append("#");
        for (String strNum : str) {
            String digit = Integer.toString(Integer.parseInt(strNum), 13);
            // 进一位数字则需要补零
            if(digit.length() == 1) {
                sb.append("0");
            }
            sb.append(digit.toLowerCase());
        }

        System.out.println(sb);
    }
}
