package com.jools.collections_;

import java.util.Iterator;
import java.util.TreeMap;

/**
 * @author Jools He
 * @date 2025/6/16 20:35
 * @description: TODO
 */
public class SortedMapDemo {

    public static void main(String[] args) {

        TreeMap<Integer, String> sortedMap = new TreeMap<>(new CountMap(10));
        System.out.println(sortedMap);
        sortedMap.put(1, "A");

        Integer low = sortedMap.firstKey();
        Integer high = sortedMap.lastKey();
        System.out.println(low);        // 0
        System.out.println(high);       // 9

        Iterator<Integer> iter = sortedMap.keySet().iterator();
        for (int i = 0; i <= 6; i++) {
            if (i == 3) low = iter.next();
            if (i == 6) high = iter.next();
            else iter.next();
        }
        System.out.println(low);    // 3
        System.out.println(high);   // 7

        // 取子区间，不包含右边界
        System.out.println(sortedMap.subMap(low, high));
        // 输出: {3=W0, 4=E0, 5=C0, 6=Q0}

        // 包含右边界
        System.out.println(sortedMap.subMap(low, true, high, true));
        // 输出: {3=W0, 4=E0, 5=C0, 6=Q0, 7=W0}

        // 小于等于 high 的子区间
        System.out.println(sortedMap.headMap(high, true));
        // 输出:{0=S0, 1=A, 2=A0, 3=W0, 4=E0, 5=C0, 6=Q0, 7=W0}

        // 小于 high 的子区间
        System.out.println(sortedMap.headMap(high));
        // 输出: {0=S0, 1=A, 2=A0, 3=W0, 4=E0, 5=C0, 6=Q0}

        // 大于等于 low 的子区间
        System.out.println(sortedMap.tailMap(low, true));
        // 输出: {3=W0, 4=E0, 5=C0, 6=Q0, 7=W0, 8=E0, 9=D0}

        // 大于 low 的子区间
        System.out.println(sortedMap.tailMap(low));
        // 输出: {3=W0, 4=E0, 5=C0, 6=Q0, 7=W0, 8=E0, 9=D0}
    }
}
