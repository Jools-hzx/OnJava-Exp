package main.java.com.jools.functional_;

import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/3/31 21:38
 * @description: TODO
 */
public class PredicateComposition {

    static Predicate<String> p1 = s -> s.contains("bar");
    static Predicate<String> p2 = s -> s.length() < 5;
    static Predicate<String> p3 = s -> s.contains("foo");
    static Predicate<String> p4 = p1.negate().and(p2).or(p3);

    public static void main(String[] args) {
        Stream.of(
                "bar",
                "foobar",
                "foobaz",
                "fongopuckey"
        ).filter(p4).forEach(System.out::println);
        // foobar  foobaz
    }
}
