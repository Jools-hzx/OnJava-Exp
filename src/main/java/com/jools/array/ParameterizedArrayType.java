package com.jools.array;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/25 17:30
 * @description: TODO
 */
public class ParameterizedArrayType {

    public static void main(String[] args) {
        Integer[] ints = {1, 2, 3, 4, 5};
        String[] strings = {"one", "two", "three", "four", "five"};
        System.out.println(MethodParameter.f(ints).length); // 5
        System.out.println(MethodParameter.f(strings).length);  // 5
    }
}

class MethodParameter {

    // 返回参数化数组
    public static <T> T[] f(T[] arg) {
        return arg;
    }
}

class ClassParameter<T> {

    // 返回参数化数组
    public T[] f(T[] arg) {
        return arg;
    }
}
