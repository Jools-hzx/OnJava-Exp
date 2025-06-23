package main.java.com.jools.stream_;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/2 17:10
 * @description: TODO
 */
public class FunctionMap {

    static String[] elements = {"12", "23", "45"};

    static Stream<String> testStream() {
        return Arrays.stream(elements);
    }

    static void test(String descr, Function<String, String> func) {
        System.out.println("--- " + descr + " ---");
        testStream()
                .map(func)
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        test("add buckets", s -> "[" + s + "]");
        /*
         输出:
         --- add buckets ---
            [12]
            [23]
            [45]
        */

        test("Incrementing", s -> {
            try {
                return Integer.parseInt(s) + 1 + "";
            } catch (NumberFormatException e) {
                return s;
            }
        });
        /*
         输出:
            --- Incrementing ---
            13
            24
            46
        */

        test("Replace", s -> s.replace("2", "9"));
        /*
         输出:
            --- Replace ---
            19
            93
            45
        */

        test("Take last digit/char",
                s -> !s.isEmpty() ? s.charAt(s.length() - 1) + "" : s);
        /*
            输出:
            --- Take last digit/char ---
            2
            3
            5
        */
    }
}
