package com.jools.str;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/8 17:06
 * @description: TODO
 */
public class SimpleFormat {

    public static void main(String[] args) {
        int x = 5;
        double y = 5.332542;
        // 旧的方式
        System.out.println("Row 1: [" + x + " " + y + "]");
        // 新的方式
        System.out.format("Row 1: [%d %f]%n", x, y);
        // 或者
        System.out.printf("Row 1: [%d %f]%n", x, y);

        /*
         输出:
            Row 1: [5 5.332542]
            Row 1: [5 5.332542]
            Row 1: [5 5.332542]
        */
    }
}
