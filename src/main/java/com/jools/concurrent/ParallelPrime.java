package com.jools.concurrent;

import java.util.List;

import static java.util.stream.LongStream.iterate;
import static java.util.stream.LongStream.rangeClosed;

/**
 * @author Jools He
 * @date 2025/6/18 15:40
 * @description: TODO
 */
public class ParallelPrime {

    static final int COUNT = 100_000;

    public static boolean isPrime(long n) {
        return rangeClosed(2, (long) Math.sqrt(n))
                .noneMatch(i -> n % i == 0);
    }

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        List<String> primes = iterate(2, i -> i + 1)
                .parallel()
                .filter(ParallelPrime::isPrime)
                .limit(COUNT)
                .mapToObj(Long::toString)
                .toList();
        System.out.println("duration: " + (System.currentTimeMillis() - start) / 1000.0 + "s");
    }
}
