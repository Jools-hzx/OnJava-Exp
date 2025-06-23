package com.jools.collections_;

import java.util.*;

/**
 * @author Jools He
 * @date 2025/6/17 15:24
 * @description: TODO
 */
public class CanonicalMapping {

    static void showKeys(Map<String, String> map) {
        List<String> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);
        System.out.println(keys);
    }

    public static void main(String[] args) {
        int size = 20;
        String[] savedKeys = new String[size];
        WeakHashMap<String, String> map = new WeakHashMap<>();
        for (int i = 0; i < size; i++) {
            String key = String.format("%03d", i);
            String value = Integer.toString(i);
            if (i % 3 == 0) {
                savedKeys[i] = key;
            }
            map.put(key, value);
        }
        showKeys(map);  // [000, 001, 002, 003, 004, 005, 006, 007, 008, 009, 010, 011, 012, 013, 014, 015, 016, 017, 018, 01
        System.gc();    // 回收未被 savedKeys 引用的对象
        showKeys(map);  // [000, 003, 006, 009, 012, 015, 018]
    }
}
