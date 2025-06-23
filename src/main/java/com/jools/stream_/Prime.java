package main.java.com.jools.stream_;

import java.util.stream.LongStream;

import static java.util.stream.LongStream.rangeClosed;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/2 17:03
 * @description: TODO
 */
public class Prime {

    // 包含了上界值。如果没有任何一个取余操作的结果为 0，则 noneMatch() 返回 true
    public static boolean isPrime(long n) {
        return rangeClosed(2, (long) Math.sqrt(n))
                .noneMatch(i -> n % i == 0);
    }

    // 生成所有区间范围的素数; noneMatch() 会在第一次失败后退出
    public LongStream numbers() {
        return LongStream.iterate(2, i -> i + 1)
                .filter(Prime::isPrime);
    }

    public static void main(String[] args) {
        new Prime()
                .numbers()
                .limit(10)
                .forEach(n -> System.out.format("%d, ", n));
        System.out.println();
        // 输出: 2, 3, 5, 7, 11, 13, 17, 19, 23, 29

        new Prime().numbers()
                .skip(90)
                .limit(10)
                .forEach(n -> System.out.format("%d, ", n));
        // 输出: 467, 479, 487, 491, 499, 503, 509, 521, 523, 541,
    }
}
