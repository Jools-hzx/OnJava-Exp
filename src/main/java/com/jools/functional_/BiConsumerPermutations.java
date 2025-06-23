package main.java.com.jools.functional_;

import java.util.function.BiConsumer;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/3/31 19:58
 * @description: TODO
 */
public class BiConsumerPermutations {

    static BiConsuemr<Integer, Double> bicid = (i, d) -> {
        System.out.format("%d, %f%n", i, d);
    };
    static BiConsumer<Double, Integer> bicdi = (d, i) -> {
        System.out.format("%d, %f%n", i, d);
    };
    static BiConsumer<Integer, Long> biciL = (i, l) -> {
        System.out.format("%d, %d%n", i, l);
    };

    public static void main(String[] args) {
        bicid.accept(11, 2.3);
        bicdi.accept(12.2, 77);
        biciL.accept(132, 1000L);

        /*
         输出:
         11, 2.300000
         12, 77.000000
         132, 1000
        */
    }
}

// BiConsumer 接口
@FunctionalInterface
interface BiConsuemr<T, U> {
    void accept(T t, U u);
}
