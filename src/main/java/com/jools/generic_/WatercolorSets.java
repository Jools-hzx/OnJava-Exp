package com.jools.generic_;

import java.util.EnumSet;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/18 20:30
 * @description: TODO
 */
public class WatercolorSets {

    public static void main(String[] args) {
        EnumSet<WaterColors> set1 = EnumSet.range(WaterColors.DEEP_YELLOW, WaterColors.BLUE);
        EnumSet<WaterColors> set2 = EnumSet.range(WaterColors.LEMON_YELLOW, WaterColors.ORANGE);

        System.out.println("set1:" + set1);  // 输出: set1:[DEEP_YELLOW, ORANGE, BLUE]
        System.out.println("set2:" + set2);  // 输出: set2:[LEMON_YELLOW, MEDIUM_YELLOW, DEEP_YELLOW, ORANGE]

        // 输出并集
        System.out.println("union(set1, set2):" + Sets.union(set1, set2));
        // 输出: union(set1, set2):[DEEP_YELLOW, BLUE, MEDIUM_YELLOW, LEMON_YELLOW, ORANGE]

        // 输出交集
        System.out.println("intersection(set1, set2):" + Sets.intersection(set1, set2));
        // 输出: intersection(set1, set2):[DEEP_YELLOW, ORANGE]

        // 剔除 set2
        System.out.println("difference(set1, set2):" + Sets.difference(set1, set2));
        // 输出: difference(set1, set2):[BLUE]

        // 并集 - 交集
        System.out.println("complement(set1, set2):" + Sets.complement(set1, set2));
        // 输出: complement(set1, set2):[BLUE, MEDIUM_YELLOW, LEMON_YELLOW]
    }
}
