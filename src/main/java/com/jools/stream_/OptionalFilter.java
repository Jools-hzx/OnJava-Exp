package main.java.com.jools.stream_;

import java.lang.annotation.ElementType;
import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/2 23:05
 * @description: TODO
 */
public class OptionalFilter {

    static String[] elements = {
            "Foo", "Bar", "Baz", "Bingo"
    };

    static Stream<String> testStream() {
        return Arrays.stream(elements);
    }

    static void test(String desc, Predicate<String> pred) {
        System.out.println(" --- [" + desc + "] -----");
        for (int i = 0; i <= elements.length; i++) {
            System.out.println(
                    testStream()
                            .skip(i)
                            .findFirst()
                            .filter(pred)
            );
        }
    }

    public static void main(String[] args) {
        test("true", str -> true);
        test("false", str -> false);
        test("!str.isEmpty", str -> !str.isEmpty());
        test("str.length() == 3", str -> str.length() == 3);
        test("startWith(\"B\")", str -> str.startsWith("B"));

        /*
        输出:
            --- [true] -----
            Optional[Foo]
            Optional[Bar]
            Optional[Baz]
            Optional[Bingo]
            Optional.empty
             --- [false] -----
            Optional.empty
            Optional.empty
            Optional.empty
            Optional.empty
            Optional.empty
             --- [!str.isEmpty] -----
            Optional[Foo]
            Optional[Bar]
            Optional[Baz]
            Optional[Bingo]
            Optional.empty
             --- [str.length() == 3] -----
            Optional[Foo]
            Optional[Bar]
            Optional[Baz]
            Optional.empty
            Optional.empty
             --- [startWith("B")] -----
            Optional.empty
            Optional[Bar]
            Optional[Baz]
            Optional[Bingo]
            Optional.empty
        */
    }
}
