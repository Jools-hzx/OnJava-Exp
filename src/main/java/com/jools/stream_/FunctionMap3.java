package main.java.com.jools.stream_;

import java.util.stream.Stream;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/2 17:21
 * @description: TODO
 */
public class FunctionMap3 {

    public static void main(String[] args) {

        // 字符转换为整数
        Stream.of("1", "5", "2", "99", "123")
                .mapToInt(Integer::parseInt)
                .forEach(n -> System.out.format("%d ", n));
        // 输出: 1 5 2 99 123
        System.out.println();

        // 整数转换为 Long
        Stream.of("17", "199", "236")
                .mapToLong(Long::parseLong)
                .forEach(n -> System.out.format("%d ", n));
        // 输出: 17 199 236
        System.out.println();

        // 字符串转换为 Double
        Stream.of("1.2", "111", "0.23")
                .mapToDouble(Double::parseDouble)
                .forEach(n -> System.out.format("%f ", n));
        // 输出: 1.200000 111.000000 0.230000
        System.out.println();
    }
}
