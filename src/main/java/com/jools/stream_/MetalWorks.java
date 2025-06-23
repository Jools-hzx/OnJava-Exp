package main.java.com.jools.stream_;

import java.util.Arrays;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/2 16:38
 * @description: TODO
 */
public class MetalWorks {

    public static void main(String[] args) {
        Arrays.stream(
                new int[]{1, 2, 3, 4}
        ).forEach(System.out::print);
        System.out.println("\n--------");   // 输出: 1234

        Arrays.stream(
                new double[]{1.1, 2.2, 3.3, 4.4}
        ).forEach(System.out::print);
        System.out.println("\n--------");   // 输出: 1.12.23.34.4

        Arrays.stream(
                new long[]{11, 22, 33, 44}
        ).forEach(System.out::print);
        System.out.println("\n--------");   // 输出: 11223344

        // 选择一个子区间
        // 从索引 2 开始，到索引 5 结束（不包含）
        Arrays.stream(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 2, 5)
                .forEach(System.out::print);    // 输出: 345
    }
}
