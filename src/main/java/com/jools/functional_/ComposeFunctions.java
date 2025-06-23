package main.java.com.jools.functional_;

import java.util.function.Function;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/3/31 21:25
 * @description: TODO
 */
public class ComposeFunctions {

    static Function<String, String> f1 = s -> {
        System.out.println(s);
        return s.replace('A', '_');
    };
    static Function<String, String> f2 = s -> s.substring(3);
    static Function<String, String> f3 = s -> s.toLowerCase();
    static Function<String, String> f4 = s -> f1.compose(f2).andThen(f3).apply(s);

    public static void main(String[] args) {
        System.out.println(f4.apply("GO AFTER ALL AMBULANCES"));
        // 输出: AFTER ALL AMBULANCES
        //      _fter _ll _mbul_nces
    }
}
