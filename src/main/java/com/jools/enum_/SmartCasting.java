package com.jools.enum_;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/5/1 17:59
 * @description: TODO
 */
public class SmartCasting {

    static void dumb(Object x) {
        if (x instanceof String) {
            String s = (String) x;
            if (!s.isEmpty()) {
                System.out.format("%d %s%n", s.length(), s.toUpperCase());
            }
        }
    }

    // 应用： Pattern Matching for instanceof
    static void smart(Object x) {
        if(x instanceof String s && !s.isEmpty()) {
            System.out.format("%d %s%n", s.length(), s.toUpperCase());
        }
    }

    public static void main(String[] args) {
        dumb("dumb");
        smart("smart");
        /*
         输出结果:
            4 DUMB
            5 SMART
        */
    }
}
