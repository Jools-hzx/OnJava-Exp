package main.java.com.jools.stream_;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/2 16:56
 * @description: TODO
 */
public class SortedComparator {

    public static void main(String[] args) {
        Arrays.stream(new int[]{1, 2, 3, 11, 4, 5, 6, 7, 8, 9})
                .sorted()
                .skip(2)
                .limit(5)
                .map(i -> i * i)
                .forEach(System.out::println);
        // 输出:9 16 25 36 49


        Arrays.stream(new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"})
                .sorted(Comparator.reverseOrder())
                .skip(2)
                .limit(8)
                .map(i -> i + i)
                .forEach(s -> System.out.print(s + " -> "));
        // 输出:  hh -> gg -> ff -> ee -> dd -> cc -> bb -> aa ->
    }
}
