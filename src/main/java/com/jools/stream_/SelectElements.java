package main.java.com.jools.stream_;

import org.junit.Test;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static main.java.com.jools.stream_.RandInts.rands;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/3 1:28
 * @description: TODO
 */
public class SelectElements {

    public static void main(String[] args) {

        // findFirst 总是选择流中的第一个元素
        System.out.println(rands().findFirst().getAsInt());

        System.out.println(
                rands().parallel().findFirst().getAsInt()
        );

        // findAny 选择流中的任意一个元素
        System.out.println(
                rands().parallel().findAny().getAsInt()
        );
    }

    @Test
    public void getLastElementFromStream() {
        OptionalInt last = IntStream.range(10, 20).reduce((n1, n2) -> n2);
        System.out.println(last.orElse(-1));    // 输出: 19

        Optional<String> lastStr = Stream.of("a", "b", "c").reduce(
                (n1, n2) -> n2);
        System.out.println(lastStr.orElse("No such Element!!!"));   // 输出: c
    }
}
