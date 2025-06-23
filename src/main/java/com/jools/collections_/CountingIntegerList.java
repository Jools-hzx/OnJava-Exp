package com.jools.collections_;

import java.util.AbstractList;

/**
 * @author Jools He
 * @date 2025/6/16 16:36
 * @description: TODO
 */
public class CountingIntegerList extends AbstractList<Integer> {

    private int size;

    public CountingIntegerList(int size) {
        // 初始化容量不能小于零
        this.size = Math.max(size, 0);
    }

    @Override
    public Integer get(int index) {
        return index;
    }

    @Override
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        CountingIntegerList flyWeightList = new CountingIntegerList(30);
        System.out.println(flyWeightList);
        System.out.println(flyWeightList.get(500));

        /*
         输出结果:
          [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17,
            18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29]
          500
        */
    }
}
