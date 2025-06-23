package main.java.com.jools.stream_;

import java.util.Random;
import java.util.stream.Stream;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/3 1:03
 * @description: TODO
 */
public class Frobnitz {

    int size;

    public Frobnitz(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Frobnitz{" +
                "size=" + size +
                '}';
    }

    static Random random = new Random(47);
    static final int BOUND = 100;

    // 生成器
    static Frobnitz supply() {
        return new Frobnitz(random.nextInt(BOUND));
    }
}

class Reduce {
    public static void main(String[] args) {
        //将生成器传递给 Stream.generate(); 由于它与 Supplier<Frobnitz> 是方法签名兼容
        Stream.generate(Frobnitz::supply)
                .limit(10)
                .peek(System.out::println)
                .reduce((f0, f1) -> f0.size < 50 ? f0 : f1) // 生成一个 Optional
                .ifPresent(System.out::println);    // 当结果不是 empty 的时候， Optional.ifPresent() 才会调用这个方法

        /*
         输出:
            Frobnitz{size=58}
            Frobnitz{size=55}
            Frobnitz{size=93}
            Frobnitz{size=61}
            Frobnitz{size=61}
            Frobnitz{size=29}
            Frobnitz{size=68}
            Frobnitz{size=0}
            Frobnitz{size=22}
            Frobnitz{size=7}
            Frobnitz{size=29}
        */
    }
}
