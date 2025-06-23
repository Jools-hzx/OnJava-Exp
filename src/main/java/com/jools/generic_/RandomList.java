package com.jools.generic_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/18 17:39
 * @description: TODO
 */
public class RandomList<T> extends ArrayList<T> {

    private Random rand = new Random(47);

    // 随机返回一个元素; 下标取值范围 [0 ~ size())
    public T select() {
        return get(rand.nextInt(size()));
    }

    public static void main(String[] args) {
        RandomList<String> rs = new RandomList<>();

        // 添加元素
        Arrays.stream(
                "The quick bronw fox jumped over the lazy brown dog".split(" ")
        ).forEach(rs::add);

        // 遍历 rs.size() 次取出所有元素
        IntStream.range(0, rs.size()).forEach(i -> {
            System.out.print(rs.select() + " -> ");
        });
        /*
         输出: brown -> over -> fox -> quick -> quick -> dog -> brown -> The -> bronw -> lazy ->
        */
    }
}
