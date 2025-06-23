package main.java.com.jools.stream_;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/3 0:21
 * @description: TODO
 */
public class ForEach {

    static final int SZ = 14;

    static void selectWords() throws IOException {
        Set<String> words =
                Files.lines(Paths.get("Cheese.dat"))
                        .flatMap(s -> Arrays.stream(s.split("\\W+")))
                        .filter(s -> !s.matches("\\d+"))
                        .map(String::trim)
                        .filter(s -> !s.isEmpty())
                        .limit(100)
                        .collect(Collectors.toCollection(TreeSet::new));
    }

    public static void main(String[] args) {
        // 方式一: 未使用 parallel() 结果显示顺序就是它们从 rands() 中出现的顺序
        RandIntsGen.rands()
                .limit(SZ)
                .forEach(n -> System.out.format("%d ", n));
        System.out.println();

        // 方式二: 引入 parallel 导致输出顺序和之前不一致；因为多个处理器在处理
        RandIntsGen.rands()
                .limit(SZ)
                .parallel()
                .forEach(n -> System.out.format("%d ", n));
        System.out.println();

        // 方式三: 最后一个流使用 parallel() 但是又使用 forEachOrdered() 方法来强制结果回到原始顺序
        RandIntsGen.rands()
                .limit(SZ)
                .parallel()
                .forEachOrdered(n -> System.out.format("%d ", n));

        /*
         输出:
            258 555 693 861 961 429 868 200 522 207 288 128 551 589
            551 589 200 522 868 288 128 258 693 207 861 961 555 429
            258 555 693 861 961 429 868 200 522 207 288 128 551 589
        */

    }
}

class RandIntsGen {

    private static int[] ints
            = new Random(47)
            .ints(0, 1000)
            .limit(100)
            .toArray();

    public static IntStream rands() {
        return Arrays.stream(ints);
    }
}
