package main.java.com.jools.functional_;

import java.util.function.Function;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/3/31 21:48
 * @description: TODO
 */
public class CurryingAndPartials {

    // 未进行柯里化
    static String uncurried(String a, String b) {
        return a + b;
    }

    public static void main(String[] args) {
        // 柯里化函数
        Function<String, Function<String, String>> sum = a -> b -> a + b;

        System.out.println(uncurried("Hi", "Ho"));
        Function<String, String> hi = sum.apply("Hi");
        System.out.println(hi.apply("Ho"));

        Function<String, String> sumHi = sum.apply("Hi ~ Jools —— ");
        System.out.println(sumHi.apply("Wakoo"));
        System.out.println(sumHi.apply("He"));
    }
}
