package com.jools.generic_;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/19 17:30
 * @description: TODO
 */
public class ArrayMaker<T> {

    private Class<?> kind;

    public ArrayMaker(Class<?> kind) {
        this.kind = kind;
    }

    @SuppressWarnings("all")
    T[] create(int size) {
        return (T[]) Array.newInstance(kind, size);
    }

    public static void main(String[] args) {
        // 类型擦除创建数组
        ArrayMaker<Object> maker = new ArrayMaker<>(String.class);
        String[] strs = (String[]) maker.create(9);
        System.out.println(Arrays.toString(strs));  // 输出: [null, null, null, null, null, null, null, null, null]
    }
}
