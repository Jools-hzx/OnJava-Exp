package main.java.com.jools.stream_;

import java.util.stream.Stream;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/3/31 23:02
 * @description: TODO
 */
public class StreamOf {

    public static void main(String[] args) {

        // 输出对象
        Stream.of(
                new Bubble(1),
                new Bubble(2),
                new Bubble(3)
        ).forEach(System.out::println);

        // 拼接字符串
        Stream.of("It's", "a", "wonderful", "world!")
                .forEach(System.out::println);
        System.out.println();

        // 输出浮点数
        Stream.of(3.14159, -10101.0, Double.MIN_VALUE, 1231.1213)
                .forEach(System.out::println);
    }
}

class Bubble {
    int val;

    public Bubble(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "Bubble{" +
                "val=" + val +
                '}';
    }
}
