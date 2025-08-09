package com.jools.xiaohui.algorithm;

/**
 * @author Jools He
 * @date 2025/8/9 17:21
 * @description: TODO
 */
public class CommonDivisor {

    public static void main(String[] args) {
        System.out.println(getGreatestCommonDiv(25, 5));
        System.out.println(getGreatestCommonDiv(100, 80));
    }

    public static int gcd(int a, int b) {
        if (a == b) {
            return a;
        }
        if ((a & 1) == 0 && (b & 1) == 0) {     // 同为偶数
            return gcd(a >> 1, b >> 1) << 1;
        } else if ((a & 1) == 0 && (b & 1) != 0) {  // a 为偶数, b 为奇数
            return gcd(a >> 1, b);
        } else if ((a & 1) != 0 && (b & 1) == 0) {  // a 为奇数, b 为偶数
            return gcd(a, b >> 1);
        } else {
            int big = Math.max(a, b);
            int small = Math.min(a, b);
            return gcd(big - small, small);
        }
    }

    public static int getGreatestCommonDivV2(int a, int b) {
        if (a == b) {
            return a;
        }
        int big = Math.max(a, b);
        int small = Math.min(a, b);
        if (big % small == 0) {
            return small;
        }
        return getGreatestCommonDivV2(big - small, small);
    }

    private static int getGreatestCommonDiv(int a, int b) {
        int big = Math.max(a, b);
        int small = Math.min(a, b);
        if (big % small == 0) {
            return small;
        }
        // big % small 求余数; 余数再压栈进入下一层递归与 small 运算
        return getGreatestCommonDiv(big % small, small);
    }
}
