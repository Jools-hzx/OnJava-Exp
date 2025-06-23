package com.jools.array;

import com.jools.reflection_.A;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/25 19:05
 * @description: TODO
 */
public class ArrayCopying {

    public static final int SZ = 15;

    public static void main(String[] args) {
        int[] a1 = new int[SZ];
        Arrays.setAll(a1, new RandGen.Integer()::get);

        int[] a2 = Arrays.copyOf(a1, a1.length);
        Arrays.fill(a2, 1);
        ArrayShow.show(a1);
        ArrayShow.show(a2);
        // 输出: [635, 8737, 3941, 4720, 6177, 8479, 6656, 3768, 4948, 6193, 5070, 5807, 2400, 125, 4762]

        // 创建更短的数组
        a2 = Arrays.copyOf(a2, a2.length / 2);
        ArrayShow.show(a2);
        // 输出: [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]

        // 同样复制包装数组; 部分长度
        Integer[] integers = new Integer[SZ];
        Arrays.setAll(integers, new RandGen.Integer()::get);
        Integer[] range = Arrays.copyOfRange(integers, 3, 10);
        ArrayShow.show(range);
        // 输出: [1, 1, 1, 1, 1, 1, 1]

        // 生成 Sub
        Sub[] d = new Sub[SZ / 2];
        for (int i = 0; i < SZ / 2; i++) {
            d[i] = new Sub();
        }
        Sup[] sups = Arrays.copyOf(d, d.length, Sup[].class);
        ArrayShow.show(sups);
        // 输出: [Sub0, Sub0, Sub0, Sub0, Sub0, Sub0, Sub0]

        // 支持向下转型: sups 存储的是 Sup 类型示例，d2 转换为 Sub 类型
        Sub[] d2 = Arrays.copyOf(sups, sups.length, Sub[].class);
        ArrayShow.show(d2);
        // 输出: [Sub0, Sub0, Sub0, Sub0, Sub0, Sub0, Sub0]

        // 向下转型 - 可以通过编译但是会抛出从 Exception
        Sup[] b2 = new Sup[SZ / 2];
        Arrays.setAll(b2, Sup::new);
        try {
            Sub[] b3 = Arrays.copyOf(b2, b2.length, Sub[].class);
        } catch (Exception e) {
            System.out.println(e);
        }
        /*
         输出:
         java.lang.ArrayStoreException: arraycopy: element type mismatch:
         can not cast one of the elements of com.jools.array.Sup[]
         to the type of the destination array, com.jools.array.Sub
        */
    }
}

class Sub extends Sup {

    Sub() {
        super();
    }
}

class Sup {
    private int id;

    public Sup() {
    }

    Sup(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + id;
    }
}
