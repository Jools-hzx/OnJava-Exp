package com.jools.generic_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/18 19:01
 * @description: TODO
 */
public class GenericVarargs {

    // 接收 T 类型参数; 封装成 List 集合
    @SafeVarargs
    public static <T> List<T> makeList(T... args) {
        List<T> result = new ArrayList<>();
        result.addAll(Arrays.asList(args));
        return result;
    }

    public static void main(String[] args) {
        List<String> ls = makeList("A");
        System.out.println(ls);

        // 返回 List<Integer> 类型结果
        List<Integer> intls = makeList(1, 2, 3, 4, 5);
        System.out.println(intls);

        // 相同参数类型的集合引用可以重复指向相同参数类型的返回结果
        ls = makeList("SDFAERARVASRRWRWRQWRWCISJOWWER".split(""));
        System.out.println(ls);

        /*
         输出:
            [A]
            [1, 2, 3, 4, 5]
            [S, D, F, A, E, R, A, R, V, A, S, R, R, W, R, W, R, Q, W, R, W, C, I, S, J, O, W, W, E, R]
        */
    }
}
