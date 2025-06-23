package main.java.com.jools.stream_;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/2 17:31
 * @description: TODO
 */
public class FlatMap {

    public static void main(String[] args) {
        // 每个流都会被扁平化处理
        Stream.of(1, 2, 3)
                .flatMap(i -> Stream.of("Gonzo", "Kermit", "Beaker"))
                .forEach(s -> System.out.print(s + " -> "));
        //输出: Gonzo -> Kermit -> Beaker -> Gonzo -> Kermit -> Beaker -> Gonzo -> Kermit -> Beaker ->
        System.out.println();


        // 整数值组成的流; 引入 concat()
        // 每个由随机的 Integer 组成的流的末尾，添加一个 -1 作为标记
        Random random = new Random(47);
        Stream.of(1, 2, 3, 4, 5).flatMapToInt(
                i -> IntStream.concat(
                        random.ints(0, 100).limit(i),
                        IntStream.of(-1)
                )
        ).forEach(s -> System.out.print(s + " | "));
        // 输出: 58 | -1 | 55 | 93 | -1 | 61 | 61 | 29 | -1 | 68 | 0 | 22 | 7 | -1 | 88 | 28 | 51 | 89 | 9 | -1 |
    }
}
