package com.jools.generic_;


import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/18 18:30
 * @description: TODO
 */
public class Fibonacci implements Supplier<Integer> {

    private int count = 0;

    //返回斐波那契数列中下一个数字
    @Override
    public Integer get() {
        return fib(count++);
    }

    // 返回斐波那契数列中的第 n 个数字
    private int fib(int n) {
        if (n < 2) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        Stream.generate(new Fibonacci())
                .limit(18)
                .map(n -> n + ", ")
                .forEach(System.out::print);
        // 输出结果: 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584,
    }
}
