package com.jools.enum_;

import java.util.EnumSet;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/26 17:30
 * @description: TODO
 */
public enum AlarmPoints {

    START1,
    START2,
    LOBBY,
    OFFICE1,
    OFFICE2,
    BATHROOM,
    UTILITY,
    KITCHEN;

    public static void main(String[] args) {
        // noneOf 返回一个空集合
        EnumSet<AlarmPoints> p = EnumSet.noneOf(AlarmPoints.class);
        p.add(BATHROOM);    // 添加
        System.out.println(p);

        p.addAll(EnumSet.of(START1, START2, LOBBY, OFFICE1));
        System.out.println(p);  // 输出: [START1, START2, LOBBY, OFFICE1, BATHROOM]

        p = EnumSet.allOf(AlarmPoints.class);
        System.out.println(p);  // 输出: [START1, START2, LOBBY, OFFICE1, OFFICE2, BATHROOM, UTILITY, KITCHEN]

        p.removeAll(EnumSet.of(OFFICE1, OFFICE2));
        System.out.println(p);  // 输出: [START1, START2, LOBBY, BATHROOM, UTILITY, KITCHEN]

        p.removeAll(EnumSet.range(OFFICE1, BATHROOM));
        System.out.println(p);  // 输出: [START1, START2, LOBBY, UTILITY, KITCHEN]

        p = EnumSet.complementOf(p);
        System.out.println(p);  // 输出:[OFFICE1, OFFICE2, BATHROOM]
    }
}
