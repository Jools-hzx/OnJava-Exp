package main.java.com.jools.stream_;

import org.junit.Test;

import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/2 22:21
 * @description: TODO
 */
public class OptionalsFromEmptyStreams {

    public static void main(String[] args) {

        // findFirst
        System.out.println(Stream.<String>empty().findFirst());
        // 输出: Optional.empty

        // findAny
        System.out.println(Stream.<String>empty().findAny());
        // 输出: Optional.empty

        // max
        System.out.println(Stream.<String>empty().max(String.CASE_INSENSITIVE_ORDER));
        // 输出:Optional.emtpy

        // min
        System.out.println(Stream.<String>empty().min(String.CASE_INSENSITIVE_ORDER));
        // 输出:Optional.emtpy

        // reduce
        System.out.println(Stream.<String>empty().reduce((s1, s2) -> s1 + s2));
        // 输出:Optional.emtpy

        // average
        System.out.println(IntStream.empty().average());
        // 输出:OptionalDouble.empty
    }


    static void test(Optional<String> optStr) {
        if (optStr.isPresent()) {
            System.out.println(optStr.get());
        } else {
            System.out.println("Nothing inside!");
        }
    }

    @Test
    public void testOptStr() {
        test(Stream.of("AADFASDF").findFirst());    // 输出: AADFASDF
        test(Stream.<String>empty().findFirst());   // 输出: Nothing inside!
    }
}
