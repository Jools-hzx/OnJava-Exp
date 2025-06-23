package main.java.com.jools.stream_;

import java.util.stream.IntStream;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/3/31 23:24
 * @description: TODO
 */
public class Ranges {

    public static void main(String[] args) {

        // 传统方式
        int result = 0;
        for (int i = 10; i < 20; i++) {
            result += i;
        }
        System.out.println(result); // 输出: 145

        // for-in 搭配一个区间范围
        result = 0;
        for (int i : IntStream.range(10, 20).toArray()) {
            result += i;
        }
        System.out.println(result); // 输出: 145

        // 使用流
        System.out.println(IntStream.range(10, 20).sum());  // 输出: 145
    }
}
