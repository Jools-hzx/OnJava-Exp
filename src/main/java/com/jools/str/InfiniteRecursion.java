package com.jools.str;

import java.util.stream.Stream;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/8 16:47
 * @description: TODO
 */
public class InfiniteRecursion {

    @Override
    public String toString() {
        return "InfiniteRecursion address:" + this + "\n";
    }

    public static void main(String[] args) {
        Stream.generate(InfiniteRecursion::new)
                .limit(10)
                .forEach(System.out::println);
    }
}
