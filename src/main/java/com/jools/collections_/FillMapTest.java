package com.jools.collections_;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/5/5 17:27
 * @description: TODO
 */
public class FillMapTest {

    public static void main(String[] args) {

        // 1. 基于 Pair 结构完成填充
        Map<Integer, Integer> m1 = FillMap.basic(
                () -> new Pair<>(new Random().nextInt(100), 111),
                5);
        System.out.println(m1);

        // 2. 基于 Supplier 结构完成填充; 返回 Map 的匿名内部类
        Map<Integer, Integer> m2 = FillMap.basic(
                () -> new Random().nextInt(100),
                () -> new Random(47).nextInt(50),
                5);
        System.out.println(m2);

        // 3. 基于 Supplier<Key % Value> 结构完成填充, 并且指定生成的 Map 类型(LinkedHashMap)
        LinkedHashMap<Integer, Integer> linkM = FillMap.create(
                () -> new Random().nextInt(100),
                () -> new Random(47).nextInt(50),
                LinkedHashMap::new,
                5
        );
        System.out.println(linkM);


        /*
         输出结果:
            {50=111, 51=111, 20=111, 24=111, 72=111}
            {68=8, 37=8, 6=8, 27=8, 77=8}
            {17=8, 13=8, 39=8, 99=8, 7=8}
        */
    }
}
