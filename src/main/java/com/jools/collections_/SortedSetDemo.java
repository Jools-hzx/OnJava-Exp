package com.jools.collections_;

import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * @author Jools He
 * @date 2025/6/16 17:54
 * @description: TODO
 */
public class SortedSetDemo {

    public static void main(String[] args) {

        TreeSet<String> sortedSet = Arrays.stream(
                "1 2 3 4 5 6 7 8".split(" ")
        ).collect(Collectors.toCollection(TreeSet::new));

        System.out.println(sortedSet);
        String low = sortedSet.first();
        String high = sortedSet.last();
        System.out.println(low);
        System.out.println(high);

        Iterator<String> iter = sortedSet.iterator();
        for (int i = 0; i <= 6; i++) {
            if (i == 3) low = iter.next();
            if (i == 6) high = iter.next();
            else iter.next();
        }

        System.out.println(low);    // 更新为 4
        System.out.println(high);   // 更新为 7
        System.out.println(sortedSet.subSet(low, high));
        System.out.println(sortedSet.headSet(high));    // 小于 high 的所有元素
        System.out.println(sortedSet.tailSet(low)); // 大于等于 low 的所有元素

        /*
        输出结果:
        [1, 2, 3, 4, 5, 6, 7, 8]
        1
        8
        4
        8
        [4, 5, 6, 7]
        [1, 2, 3, 4, 5, 6, 7]
        [4, 5, 6, 7, 8]
        */
    }
}
