package com.jools.array;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/25 16:56
 * @description: TODO
 */
public class ArrayOperations {

    public static void main(String[] args) {
        // 创建对象数组
        BerylliumSphere[] a;
        BerylliumSphere[] b = new BerylliumSphere[5];

        // 数组内部的引用被自动初始化 null;
        ArrayShow.show("b", b);

        BerylliumSphere[] c = new BerylliumSphere[4];
        for (int i = 0; i < c.length; i++) {
            // 可以检查是否为 null 引用
            if (c[i] == null) {
                c[i] = new BerylliumSphere();
            }
        }

        // 批量初始化
        BerylliumSphere[] d = {
                new BerylliumSphere(),
                new BerylliumSphere(),
                new BerylliumSphere()
        };

        // 访问数组长度
//        System.out.println("a.length:" + a.length);    报错，未初始化
        System.out.println("b.length:" + b.length);
        System.out.println("c.length:" + c.length);
        System.out.println("d.length:" + d.length);
        a = d;
        System.out.println("a.length:" + a.length);

        // 基本类型数组
        int[] e;    // 空引用
        int[] f = new int[5];

        // 数组中的基本类型自动被初始化为 0
        ArrayShow.show("f", f);
        int[] g = new int[4];
        for (int i = 0; i < g.length; i++) {
            g[i] = i * i;
        }

        int[] h = {11, 47, 93};

//        System.out.println("e.length:" + e.length); 报错，e 为 null
        System.out.println("f.length:" + f.length);
        System.out.println("f.length:" + f.length);
        System.out.println("f.length:" + f.length);
        e = h;  // 赋值，更新引用
        System.out.println("e.length:" + e.length);
        e = new int[]{1, 2};    // 重新赋值
        System.out.println("e.length:" + e.length);
    }
}
