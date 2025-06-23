package com.jools.collections_;

import java.util.Map;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/5/5 17:03
 * @description: TODO
 */
public class StreamFillMaps {

    public static void main(String[] args) {
        Map<Integer, String> m = Stream.generate(new Letters())
                .limit(11)
                .collect(Collectors.toMap(Pair::key, Pair::value));
        m.keySet().forEach(k -> System.out.print(k + ":" + m.get(k) + "\t"));
        System.out.println();

        // 用一个类来生成键，它们使用同一个值
        Map<Integer, String> mcs2 = Stream.generate(
                () -> Pair.make(new Random().nextInt(100), "Val")
        ).limit(8).collect(Collectors.toMap(
                Pair::key, Pair::value
        ));
        System.out.println(mcs2);
        /*
         输出结果:
         1:A      2:B	   3:C      4:D	    5:E	    6:F	    7:G    8:H     9:I      10:J    11:K
        {66=Val, 18=Val, 35=Val, 38=Val, 71=Val, 59=Val, 93=Val, 62=Val}
        */
    }
}

class Letters implements Supplier<Pair<Integer, String>> {
    private int number = 1;
    private char letter = 'A';

    @Override
    public Pair<Integer, String> get() {
        return new Pair<>(number++, "" + (letter++));
    }
}
