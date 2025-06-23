package com.jools.designpattern.singleton;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/1/8 20:19
 * @description: TODO
 */
public class Triple {
    private static Triple triple = new Triple();
    private int no = 0;

    private static int instancesCnt = 0;

    public int getNo() {
        return no++;
    }

    public static Triple getInstance() {
        instancesCnt++;
        if (instancesCnt > 3) {
            throw new RuntimeException("生成超过3个实例!");
        }
        return triple;
    }
}
