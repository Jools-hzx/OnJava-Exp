package com.jools.assertion;

import java.util.function.Consumer;

import static com.google.common.base.Preconditions.*;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/5 22:50
 * @description: TODO
 */
public class GuavaPreconditions {

    static void test(Consumer<String> c, String s) {
        try {
            System.out.println(s);
            c.accept(s);
            System.out.println("Success");
        } catch (Exception e) {
            String type = e.getClass().getSimpleName();
            String msg = e.getMessage();
            System.out.println(type + (msg == null ? "" : ": " + msg));
        }
    }

    public static void main(String[] args) {
        test(s -> s = checkNotNull(s), "X");    // Success
        test(s -> s = checkNotNull(s), null);   // NullPointerException

        // 断言: 是否为 Null
        test(s -> s = checkNotNull(s, "s was null"), null); // NullPointerException: s was null
        test(s -> s = checkNotNull(s, "s was null, %s %s", "arg2", "arg3"), null);  // NullPointerException: s was null, arg2 arg3

        // 断言: 参数校验
        test(s -> checkArgument(s.equals("Fozzie")), "Fozzie");       // Success
        test(s -> checkArgument(s == "Fozzie"), "X");       // IllegalArgumentException
        test(s -> checkArgument(s == "Fozzie"), null);      // IllegalArgumentException

        // 新增配置信息
        test(s -> checkArgument(s == "Fozzie", "Arg does not match"), null);    // IllegalArgumentException: Arg does not match
        test(s -> checkArgument(s.equals("Fozzie"), "Bear Left! %s Right!", "Frog"), null); // NullPointerException: Cannot invoke "String.equals(Object)" because "s" is null

        // 断言: 长度
        test(s -> checkState(s.length() > 6), "Mortimer");  // Success
        test(s -> checkState(s.length() > 6), "Mort");  // IllegalStateException
        test(s -> checkState(s.length() > 6), null);    // NullPointerException: Cannot invoke "String.length()" because "s" is null

        // 断言: 校验下标合法，并检查元素
        test(s -> checkElementIndex(6, s.length()), "Robert");  // IndexOutOfBoundsException: index (6) must be less than size (6)
        test(s -> checkElementIndex(6, s.length()), "Bob");  // IndexOutOfBoundsException: index (6) must be less than size (3)
        test(s -> checkElementIndex(6, s.length()), null);  // NullPointerException: Cannot invoke "String.length()" because "s" is null

        // 断言:
        test(s -> checkPositionIndexes(0, 6, s.length()), "Hieronymus");    // Success
        test(s -> checkPositionIndexes(0, 10, s.length()), "Hieronymus");   // Success
        test(s -> checkPositionIndexes(0, 11, s.length()), "Hieronymus");   // IndexOutOfBoundsException: end index (11) must not be greater than size (10)
        test(s -> checkPositionIndexes(-1, 6, s.length()), "Hieronymus");   // IndexOutOfBoundsException: start index (-1) must not be negative
        test(s -> checkPositionIndexes(7, 6, s.length()), "Hieronymus");    // IndexOutOfBoundsException: end index (6) must not be less than start index (7)
        test(s -> checkPositionIndexes(0, 6, s.length()), null);            // NullPointerException: Cannot invoke "String.length()" because "s" is null
    }
}
