package main.java.com.jools.pat;

import java.util.Scanner;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/3/18 13:59
 * @description: TODO
 */
public class Pat1009Demo {


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] line01 = s.nextLine().split("\\s+");
        String[] line02 = s.nextLine().split("\\s+");
        int n1 = Integer.valueOf(line01[0]);    // 第一行输入了多少个多项式
        int n2 = Integer.valueOf(line02[0]);    // 第二行输入了多少个多项式

        // 系数相乘; 指数相加; 奇数位下标位系数，偶数位下标为指数
        float[] coes = new float[n1 * n2 + 1];    // 最多有 n1 * n2 中指数可能; 下标 i 记录指数为 i 的系数
        boolean[] exps = new boolean[n1 * n2 + 1];    // 标记指数 i 是否出现
        for (int i = 1; i < line01.length; i += 2) {
            int exp1 = Integer.valueOf(line01[i]);
            float coe1 = Float.valueOf(line01[i + 1]);
            for (int j = 1; j < line02.length; j += 2) {
                int exp2 = Integer.valueOf(line02[j]);
                float coe2 = Float.valueOf(line02[j + 1]);
                int sumExp = exp1 + exp2;
                if (!exps[sumExp]) {        // 指数相加
                    exps[sumExp] = true;
                }
                float sumCoe = coe1 * coe2;
                sumCoe = Math.round(sumCoe * 10) / 10.0f;
                coes[sumExp] += sumCoe;    // 更新当前指数的系数和
            }
        }

        // 从指数高往低输出
        int polys = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = exps.length - 1; i >= 0; i--) {
            if (exps[i]) {
                sb.append(i).append(" ").append(coes[i]);
                polys++;
            }
        }
        if (polys == 0) {
            System.out.print(polys);
            return;
        }
        System.out.print(polys + " ");    // 输出多项式个数
        System.out.print(sb.toString());
    }
}

