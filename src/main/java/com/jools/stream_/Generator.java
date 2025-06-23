package main.java.com.jools.stream_;

import com.google.errorprone.annotations.Var;

import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/2 16:21
 * @description: TODO
 */
public class Generator implements Supplier<String> {

    Random rand = new Random(47);

    char[] letters = "sfhauswnefwfwpofapkefopwaf".toCharArray();

    @Override
    public String get() {
        return "" + letters[rand.nextInt(letters.length)];
    }

    public static void main(String[] args) {
        // 借助 Supplier 的 generate() 方法生成流
        List<String> collect = Stream.generate(new Generator())
                .limit(15)
                .collect(Collectors.toList());
        System.out.println(collect);
        // 输出: [a, p, f, f, p, p, a, w, h, s, o, p, f, p, e]
    }
}
