package com.jools.collections_;

import java.util.*;

/**
 * @author Jools He
 * @date 2025/6/16 17:02
 * @description: TODO
 */
public class CollectionMethods {

    static List<String> LIST = List.of(
            "AAA",
            "BBB",
            "CCC",
            "DDD",
            "EEE",
            "FFF",
            "GGG",
            "HHH",
            "III",
            "JJJ",
            "KKK",
            "LLL",
            "MMM"
    );

    public static void main(String[] args) {

        Collection<String> c = new ArrayList<>(LIST);
        // 添加操作
        c.add("Jools");

        // 输出展示
        show(c);
        System.out.println();
        border();

        // 从 List 中创建一个数组
        Object[] array = c.toArray();
        System.out.println("Object Array:" + Arrays.toString(array));
        // 从 List 创建一个 String 数组
        String[] strArr = c.toArray(new String[0]);
        System.out.println("String Array:" + Arrays.toString(strArr));
        border();

        // 寻找最大和最小元素
        System.out.println("Collection find max:" + Collections.max(c));
        System.out.println("Collection find min:" + Collections.min(c));
        border();

        // 移除元素
        Collection<String> c2 = new ArrayList<>(LIST.subList(0, 4));
        c.remove(LIST.get(0));
        // 移除全部
        c.removeAll(c2);
        // 添加全部
        c.addAll(c2);
        show(c);
        System.out.println();
        border();

        // 检查某个元素是否在该集合中
        System.out.println("c.containsAll(c2):" + c.containsAll(c2));

        // 是否为空
        System.out.println("c.isEmpty():" + c.isEmpty());
        border();

        // 函数式操作
        c.removeIf(s -> s.startsWith("CCC"));

        // 流操作
        c.forEach(System.out::print);
        System.out.println();

        /*
         显示结果:
            AAABBBCCCDDDEEEFFFGGGHHHIIIJJJKKKLLLMMMJools
            ------------------------------------------
            Object Array:[AAA, BBB, CCC, DDD, EEE, FFF, GGG, HHH, III, JJJ, KKK, LLL, MMM, Jools]
            String Array:[AAA, BBB, CCC, DDD, EEE, FFF, GGG, HHH, III, JJJ, KKK, LLL, MMM, Jools]
            ------------------------------------------
            Collection find max:MMM
            Collection find min:AAA
            ------------------------------------------
            EEEFFFGGGHHHIIIJJJKKKLLLMMMJoolsAAABBBCCCDDD
            ------------------------------------------
            c.containsAll(c2):true
            c.isEmpty():false
            ------------------------------------------
            EEEFFFGGGHHHIIIJJJKKKLLLMMMJoolsAAABBBDDD
        */
    }

    private static void show(Collection<?> c) {
        c.forEach(System.out::print);
    }

    private static void border() {
        System.out.println("------------------------------------------");
    }
}
