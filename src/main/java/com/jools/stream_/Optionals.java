package main.java.com.jools.stream_;

import org.checkerframework.checker.index.qual.NonNegative;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/2 22:38
 * @description: TODO
 */
public class Optionals {

    static void basics(Optional<String> optStr) {
        if (optStr.isPresent()) {
            System.out.println(optStr.get());
        } else {
            System.out.println("Nothing inside!");
        }
    }

    static void ifPresent(Optional<String> optStr) {
        optStr.ifPresent(System.out::println);
    }

    static void orElse(Optional<String> optStr) {
        System.out.println(optStr.orElse("Nada"));
    }

    static void orElseGet(Optional<String> optStr) {
        System.out.println(optStr.orElse("Generated"));
    }

    static void orElseThrow(Optional<String> optStr) {
        try {
            System.out.println(optStr.orElseThrow(
                    () -> new Exception("Supplied Exception")));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    static void test(String testName, Consumer<Optional<String>> cos) {
        System.out.println("---" + testName + "---");
        cos.accept(Stream.of("Stream.of created").findFirst());
        cos.accept(Stream.<String>empty().findFirst());
    }

    public static void main(String[] args) {
        test("basics", Optionals::basics);
        test("ifPresent", Optionals::ifPresent);
        test("orElse", Optionals::orElse);
        test("orElseGet", Optionals::orElseGet);
        test("orElseThrow", Optionals::orElseThrow);

        /*
         输出:
            ---basics---
            Stream.of created
            Nothing inside!
            ---ifPresent---
            Stream.of created
            ---orElse---
            Stream.of created
            Nada
            ---orElseGet---
            Stream.of created
            Generated
            ---orElseThrow---
            Stream.of created
            Supplied Exception
        */
    }
}
