package com.jools.array;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/25 17:39
 * @description: TODO
 */
public class ArrayOfGenericType<T> {

    T[] array;  // OK

    @SuppressWarnings("all")
    public ArrayOfGenericType(int size) {
//         array = new T[size];  // 错误: Type parameter 'T' cannot be instantiated directly
        array = (T[]) new Object[size];  // Object 类型数组没有真正持有或者动态检查类型 T， 因此告警
//         array = (T[]) new T[size];  // 错误: Type parameter 'T' cannot be instantiated directly
    }
}
