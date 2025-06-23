package com.jools.generic_;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/19 19:44
 * @description: TODO
 */
public class GenericArrayWithTypeToken<T> {

    private T[] array;

    @SuppressWarnings("all")
    public GenericArrayWithTypeToken(Class<?> t, int size) {
        // 借助类型标记和 Array.newInstance 创建特定类型的数组
        this.array = (T[]) Array.newInstance(t, size);
    }

    public void put(int idx, T item) {
        array[idx] = item;
    }

    public T get(int idx) {
        return array[idx];
    }

    // 暴露潜在的表达方式
    public T[] req() {
        return array;
    }

    public static void main(String[] args) {
        GenericArrayWithTypeToken<Integer> gai =
                new GenericArrayWithTypeToken<>(Integer.class, 10);

        // 正常运行
        Integer[] req = gai.req();
        System.out.println(Arrays.toString(req));
    }
}
