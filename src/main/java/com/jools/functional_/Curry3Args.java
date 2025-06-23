package main.java.com.jools.functional_;

import java.util.function.Function;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/3/31 21:54
 * @description: TODO
 */
public class Curry3Args {

    public static void main(String[] args) {

        Function<String,
                Function<String,
                        Function<String, String>>> sum = a -> b -> c -> a + b + c;

        Function<String, Function<String, String>> hi = sum.apply("Hi ~ Jools —— ");
        Function<String, String> next = hi.apply("This is Wakoo");
        String ans = next.apply("This is final!");
        System.out.println(ans);    // 输出: Hi ~ Jools —— This is WakooThis is final!
    }
}
