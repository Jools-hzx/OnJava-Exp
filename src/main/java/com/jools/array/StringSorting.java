package com.jools.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.SplittableRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/25 21:13
 * @description: TODO
 */
public class StringSorting {

    public static void main(String[] args) {
        final SplittableRandom rand = new SplittableRandom(47);

        String[] array = Stream
                .generate(() -> {
                    int r = rand.nextInt(64);
                    if (r % 2 == 0) return r + "abc";
                    else return (char) r + "vaBA";
                })
                .limit(20)
                .toList()
                .toArray(new String[]{});
        ArrayShow.show("Before sort", array);
        // 默认排序
        Arrays.sort(array);
        ArrayShow.show(array);

        Arrays.sort(array, Collections.reverseOrder());
        ArrayShow.show("Reverse sort", array);

        Arrays.sort(array, String.CASE_INSENSITIVE_ORDER);
        ArrayShow.show("Case-insensitive sort:", array);
    }
}
