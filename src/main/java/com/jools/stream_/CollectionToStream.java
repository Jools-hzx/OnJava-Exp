package main.java.com.jools.stream_;

import java.util.*;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/3/31 23:09
 * @description: TODO
 */
public class CollectionToStream {

    public static void main(String[] args) {

        // 1. List 转换为 Stream 后处理
        List<Bubble> list = Arrays.asList(
                new Bubble(1),
                new Bubble(2),
                new Bubble(3)
        );
        // 输出求和
        System.out.println(list.
                stream().
                mapToInt(b -> b.val).
                sum());
        /*
         输出:
         6
        */

        // 2. Set 转化为 Stream 后处理
        Set<String> w = new HashSet<>(
                Arrays.asList("Hello world jools wakoo".split("\\s+"))
        );
        w.stream().map(x -> x + "!").forEach(System.out::println);
        System.out.println();

        /*
         输出:
         world!
         Hello!
         jools!
         wakoo!
        */

        //3. Map 转换为 Stream 后处理
        Map<String, Integer> m = new HashMap<>();
        m.put("Jools", 1);
        m.put("Wakoo", 2);
        m.put("He", 3);

        m.entrySet().
                stream().
                map(e -> e.getKey() + " = " + e.getValue()).
                forEach(System.out::println);
        /*
         输出:
         He = 3
         Jools = 1
         Wakoo = 2
        */
    }
}
