package main.java.com.jools.stream_;

import java.util.stream.Stream;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/2 16:30
 * @description: TODO
 */
public class Fibonacci {

    int x = 1;

    Stream<Integer> numbers() {
        return Stream.iterate(0, i -> {
            int result = x + i;
            x = i;
            return result;
        });
    }

    public static void main(String[] args) {
        // Stream iterate() 从第一个种子开始，然后将其传给第二个参数所引用的方法
        new Fibonacci().numbers()
                .skip(20)       //不使用前 20 个
                .limit(10)  // 然后从中取 10 个
                .forEach(System.out::println);
        /*
         输出:
            6765
            10946
            17711
            28657
            46368
            75025
            121393
            196418
            317811
            514229
        */
    }
}
