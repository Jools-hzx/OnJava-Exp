package com.jools.array;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/25 18:30
 * @description: TODO
 */
public interface ConvertTo {

    // 从包装类型转换为基本类型
    static boolean[] primitive(Boolean[] in) {
        boolean[] res = new boolean[in.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = in[i];
        }
        return res;
    }

    static int[] primitive(Integer[] in) {
        int[] res = new int[in.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = in[i];
        }
        return res;
    }

    // 从基本类型转换为包装类型数组
    static Boolean[] boxed(boolean[] in) {
        Boolean[] res = new Boolean[in.length];
        for (int i = 0; i < in.length; i++) {
            res[i] = in[i];
        }
        return res;
    }

    static Integer[] boxed(int[] in) {
        Integer[] res = new Integer[in.length];
        for (int i = 0; i < in.length; i++) {
            res[i] = in[i];
        }
        return res;
    }
}
