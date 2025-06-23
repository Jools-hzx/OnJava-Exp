package com.jools.generic_;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/19 19:26
 * @description: TODO
 */
public class GenericArray<T> {

    private T[] array;

    public GenericArray(int size) {
        this.array = (T[]) new Object[size];
    }

    public void put(int idx, T item) {
        array[idx] = item;
    }

    public T get(int idx) {
        return array[idx];
    }

    // 暴露潜在表现形式的方法
    public T[] req() {
        return array;
    }

    public static void main(String[] args) {
        GenericArray<Integer> gai = new GenericArray<>(10);
        try {
            Integer[] ia = gai.req();
        } catch (Exception e) {
            // 捕获输出:class [Ljava.lang.Object; cannot be cast to class
            // [Ljava.lang.Integer; ([Ljava.lang.Object;
            // and [Ljava.lang.Integer; are in module java.base of loader 'bootstrap')
            System.out.println(e.getMessage());
        }
        Object[] objArray = gai.req();  // 合法
    }
}
