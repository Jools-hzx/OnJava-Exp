package com.jools.collections_;

import java.util.LinkedHashMap;

/**
 * @author Jools He
 * @date 2025/6/16 20:43
 * @description: TODO
 */
public class LinkedHashMapDemo {
    public static void main(String[] args) {

        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>(new CountMap(9));
        System.out.println(linkedHashMap);
        // 输出: {0=S0, 1=F0, 2=A0, 3=W0, 4=E0, 5=C0, 6=Q0, 7=W0, 8=E0}

        linkedHashMap.put(1, "one");

        // 按照最近最少使用的顺序:
        linkedHashMap = new LinkedHashMap<>(16, 0.75F, true);
        linkedHashMap.putAll(new CountMap(9));
        System.out.println(linkedHashMap);
        // 输出: {0=S0, 1=F0, 2=A0, 3=W0, 4=E0, 5=C0, 6=Q0, 7=W0, 8=E0}

        for (int i = 0; i < 6; i++) {
            linkedHashMap.get(i);
        }
        System.out.println(linkedHashMap);
        // 输出: {6=Q0, 7=W0, 8=E0, 0=S0, 1=F0, 2=A0, 3=W0, 4=E0, 5=C0}

        linkedHashMap.get(0);
        System.out.println(linkedHashMap);
        // 输出: {6=Q0, 7=W0, 8=E0, 1=F0, 2=A0, 3=W0, 4=E0, 5=C0, 0=S0}
    }
}
