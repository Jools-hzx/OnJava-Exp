package main.java.com.jools.stream_;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/2 23:18
 * @description: TODO
 */
public class OptionalMapFunc {

    static String[] elements = {"12", "", "23", "45"};

    static Stream<String> testStream() {
        return Arrays.stream(elements);
    }

    static void test(String desc, Function<String, String> func) {
        System.out.println(" ---(" + desc + " )---");
        for (int i = 0; i <= elements.length; i++) {
            System.out.println(
                    testStream()
                            .skip(i)
                            .findFirst()    // 生成一个 Optional
                            .map(func)
            );
        }
    }

    public static void main(String[] args) {
        // 如果 Optional 不为 Optional, 将其传给函数的时候，map() 首先会提取Optional 中的对象
        test("add brackets", s -> "[" + s + "]");
        /*
         输出:
            ---(add brackets )---
            Optional[[12]]
            Optional[[]]
            Optional[[23]]
            Optional[[45]]
            Optional.empty
        */

        test("Increment", s -> {
            try {
                return Integer.parseInt(s) + 1 + "";
            } catch (NumberFormatException e) {
                return s;
            }
        });

        /*
         输出:
            ---(Increment )---
            Optional[13]
            Optional[]
            Optional[24]
            Optional[46]
            Optional.empty
        */

        test("Replace", s -> s.replace("2", "9"));
        /*
         输出:
          ---(Replace )---
            Optional[19]
            Optional[]
            Optional[93]
            Optional[45]
            Optional.empty
        */

        test("LastDigit", s -> !s.isEmpty() ? s.charAt(s.length() - 1) + "" : s);
        /*
         输出:
          ---(LastDigit )---
            Optional[2]
            Optional[]
            Optional[3]
            Optional[5]
            Optional.empty
         */
    }
}
