package main.java.com.jools.stream_;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/2 23:32
 * @description: TODO
 */
public class OptionalFlatMap {

    static String[] elements = {"12", "", "23", "45"};

    static Stream<String> testStream() {
        return Arrays.stream(elements);
    }

    static void test(String desc, Function<String, Optional<String>> func) {
        System.out.println("---( " + desc + " )---");
        for (int i = 0; i <= elements.length; i++) {
            System.out.println(
                    testStream()
                            .skip(i)
                            .findFirst()
                            .flatMap(func));
        }
    }

    public static void main(String[] args) {
        test("Add brackets", s -> Optional.of("[" + s + "]"));
        /*
         输出:
            ---( Add brackets )---
            Optional[[12]]
            Optional[[]]
            Optional[[23]]
            Optional[[45]]
            Optional.empty
        */

        test("Increment", s -> {
            try {
                return Optional.of(Integer.parseInt(s) + 1 + "");
            } catch (NumberFormatException e) {
                return Optional.of(s);
            }
        });
        /*
         输出:
           ---( Increment )---
            Optional[13]
            Optional[]
            Optional[24]
            Optional[46]
            Optional.empty
        */

        test("Replace",
                s -> Optional.of(s.replace("2", "9"))
        );
        /*
            ---( Replace )---
            Optional[19]
            Optional[]
            Optional[93]
            Optional[45]
            Optional.empty
        */

        test("Take Last Digit",
                s -> Optional.of(
                        !s.isEmpty() ? s.charAt(s.length() - 1) + "" : s));
        /*
        输出:
            ---( Take Last Digit )---
            Optional[2]
            Optional[]
            Optional[3]
            Optional[5]
            Optional.empty
        */
    }
}
