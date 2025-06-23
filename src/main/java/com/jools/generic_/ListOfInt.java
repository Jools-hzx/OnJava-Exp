package com.jools.generic_;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/21 16:58
 * @description: TODO
 */
public class ListOfInt {

    public static void main(String[] args) {

        List<Integer> collected = IntStream.range(38, 48)
                .boxed()
                .collect(Collectors.toList());
        collected.forEach(System.out::print);
        // 输出结果:38394041424344454647
    }
}
