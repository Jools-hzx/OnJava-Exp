package main.java.com.jools.stream_;

import java.util.Optional;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/2 22:52
 * @description: TODO
 */
public class CreatingOptionals {

    public static void main(String[] args) {
        test("Empty", Optional.empty());
        test("of", Optional.of("Howdy"));
        try {
            test("of", Optional.of(null));
        } catch (Exception e) {
            System.out.println(e);
        }
        test("ofNullable", Optional.ofNullable("Hi"));
        test("ofNullable", Optional.ofNullable(null));

        /*
        输出:
        ====Empty=====
        NULL
        ====of=====
        Howdy
        java.lang.NullPointerException
        ====ofNullable=====
        Hi
        ====ofNullable=====
        NULL
        */
    }

    static void test(String testName, Optional<String> opt) {
        System.out.println("====" + testName + "=====");
        System.out.println(opt.orElse("NULL"));
    }
}
