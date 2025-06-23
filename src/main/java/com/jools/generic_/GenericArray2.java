package com.jools.generic_;

import java.util.Arrays;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/19 19:36
 * @description: TODO
 */
public class GenericArray2<T> {
    private Object[] array;

    public GenericArray2(int size) {
        this.array = new Object[size];
    }

    public void put(int idx, T item) {
        array[idx] = item;
    }

    // 返回未检测的类型转换元素
    public T get(int idx) {
        return (T) array[idx];
    }

    // 未检测的类型转换
    public T[] req() {
        return (T[]) array;
    }

    public static void main(String[] args) {
        GenericArray2<Integer> gai = new GenericArray2<>(10);
        for (int i = 0; i < 10; i++) {
            gai.put(i, i);
        }
        for (int i = 0; i < 10; i++) {
            System.out.print(gai.get(i) + ", ");
        }
        System.out.println();

        try {
            Integer[] ia = gai.req();
            System.out.println(Arrays.toString(ia));
        } catch (Exception e) {
            // 捕获输出: java.lang.ClassCastException: class
            // [Ljava.lang.Object; cannot be cast to class [Ljava.lang.Integer; ([Ljava.lang.Object;
            // and [Ljava.lang.Integer; are in module java.base of loader 'bootstrap')
            System.out.println(e);
        }
    }
}
