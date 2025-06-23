package main.java.com.jools.stream_;

import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/3 1:17
 * @description: TODO
 */
public class Matching {

    static void show(Matcher match, int val) {
        System.out.println(
                match.test(
                        IntStream.rangeClosed(1, 9)
                                .boxed()
                                .peek(n -> System.out.format("%d ", n)),
                        n -> n < val));
    }

    public static void main(String[] args) {
        show(Stream::allMatch, 10);
        show(Stream::allMatch, 4);
        show(Stream::anyMatch, 2);
        show(Stream::anyMatch, 0);
        show(Stream::noneMatch, 5);
        show(Stream::noneMatch, 0);

        /*
        输出:
            1 2 3 4 5 6 7 8 9 true
            1 2 3 4 false
            1 true
            1 2 3 4 5 6 7 8 9 false
            1 false
            1 2 3 4 5 6 7 8 9 true
        */
    }
}

interface Matcher extends BiPredicate<Stream<Integer>, Predicate<Integer>> {
}