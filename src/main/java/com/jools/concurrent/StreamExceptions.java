package com.jools.concurrent;

import java.util.stream.Stream;

/**
 * @author Jools He
 * @date 2025/6/19 20:21
 * @description: TODO
 */
public class StreamExceptions {

    static Stream<Breakable> test(String id, int failCount) {
        return Stream.of(new Breakable(id, failCount))
                .map(Breakable::work)
                .map(Breakable::work)
                .map(Breakable::work);
    }

    public static void main(String[] args) {

        // 没有进行操作
        test("A", 1);
        test("B", 2);
        Stream<Breakable> c = test("C", 3);
        test("D", 4);
        test("E", 5);

        // 有异常抛出，但是没有进行操作
        System.out.println("Entering try");
        try {
            c.forEach(System.out::println);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
