package main.java.com.jools.stream_;

import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/3 0:49
 * @description: TODO
 */
public class MapCollector {

    public static void main(String[] args) {

        // 获取 8 个随机的 Pair 对象，然后使用 collect() 方法将它们收集到一个 Map 中
        Map<Integer, Character> map =
                new RandomPair().stream()
                        .limit(8)
                        .collect(Collectors.toMap(Pair::getI, Pair::getC));
        System.out.println(map);
        System.out.println(map.getClass().getName());
        /*
            输出:
            {688=W, 293=B, 309=C, 761=N, 858=N, 668=G, 622=F, 751=N}
            java.util.HashMap
        */
    }
}

class RandomPair {
    Random random = new Random(47);

    // 无限大的迭代器，指向随机生成的大写字母
    Iterator<Character> capChars = random.ints(65, 91)
            .mapToObj(i -> (char) i)
            .iterator();

    // 通过迭代器生成 Pair 对象的 Stream;
    // 其中 Pair 对象是由随机生成的大写字母与随机生成的 100 ~ 1000 范围内的整数值组成的键值对
    public Stream<Pair> stream() {
        return random.ints(100, 1000)
                .distinct()
                .mapToObj(i -> new Pair(capChars.next(), i));
    }
}

/*
 基本数据对象，保存着 c 和 i 的值
*/
class Pair {

    public final Character c;
    public final Integer i;

    Pair(Character c, Integer i) {
        this.c = c;
        this.i = i;
    }

    public Character getC() {
        return c;
    }

    public Integer getI() {
        return i;
    }

    @Override
    public String toString() {
        return "Pair(" +
                "c=" + c +
                ", i=" + i +
                ')';
    }
}