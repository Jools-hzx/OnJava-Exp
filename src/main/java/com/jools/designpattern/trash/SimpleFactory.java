package com.jools.designpattern.trash;

import java.util.Arrays;
import java.util.List;
import java.util.SplittableRandom;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @author Jools He
 * @date 2025/6/23 2:41
 * @description: TODO
 */
public class SimpleFactory {
    static final List<Function<Double, Trash>> constructors =
            Arrays.asList(
                    Aluminum::new,
                    Paper::new,
                    Glass::new
            );

    static final int SIZE = constructors.size();

    private static SplittableRandom rand = new SplittableRandom(42);

    public static Trash random() {
        return constructors
                .get(rand.nextInt(SIZE))
                .apply(rand.nextDouble());
    }
}

class RecycleA {
    public static void main(String[] args) {
        List<Trash> bin = Stream.generate(SimpleFactory::random)
                .limit(10)
                .toList();
        Bins bins = new Bins(bin);
        bins.show();

        /*
         输出:
            Aluminum weight: 0.34 * price: 1.67 = 0.57
            Aluminum weight: 0.62 * price: 1.67 = 1.03
            Aluminum weight: 0.49 * price: 1.67 = 0.82
            Aluminum weight: 0.50 * price: 1.67 = 0.83
            Total Aluminum value = 3.26
            Paper weight: 0.69 * price: 0.10 = 0.07
            Total Paper value = 0.07
            Glass weight: 0.16 * price: 0.23 = 0.04
            Glass weight: 0.87 * price: 0.23 = 0.20
            Glass weight: 0.80 * price: 0.23 = 0.18
            Glass weight: 0.52 * price: 0.23 = 0.12
            Glass weight: 0.20 * price: 0.23 = 0.05
            Total Glass value = 0.59
            Total Cardboard value = 0.00
            Glass weight: 0.16 * price: 0.23 = 0.04
            Aluminum weight: 0.34 * price: 1.67 = 0.57
            Glass weight: 0.87 * price: 0.23 = 0.20
            Glass weight: 0.80 * price: 0.23 = 0.18
            Aluminum weight: 0.62 * price: 1.67 = 1.03
            Aluminum weight: 0.49 * price: 1.67 = 0.82
            Glass weight: 0.52 * price: 0.23 = 0.12
            Glass weight: 0.20 * price: 0.23 = 0.05
            Aluminum weight: 0.50 * price: 1.67 = 0.83
            Paper weight: 0.69 * price: 0.10 = 0.07
            Total Trash value = 3.91
        */
    }
}
