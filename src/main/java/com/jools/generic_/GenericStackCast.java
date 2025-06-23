package com.jools.generic_;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/21 17:39
 * @description: TODO
 */
public class GenericStackCast {

    static String[] letters = "ABDASREQADCASERRWE".split("");


    public static void main(String[] args) {
        FixedSizeStack<String> str = new FixedSizeStack<>(letters.length);
        // 遍历将所有字符压栈
        Arrays.stream(letters).forEach(str::push);

        // 弹出栈顶
        System.out.println(str.pop());
        str.stream().map(s -> s + " ").forEach(System.out::print);
        /*
         输出:
            E
            A B D A S R E Q A D C A S E R R W E
        */
    }
}

class FixedSizeStack<T> {

    private final int size;

    private Object[] storage;
    private int index = 0;

    public FixedSizeStack(int size) {
        this.size = size;
        this.storage = new Object[size];
    }

    public void push(T t) {
        if (index < size) {
            storage[index++] = t;
        }
    }

    // 告警: Unchecked cast: 'java.lang.Object' to 'T'
    public T pop() {
        return index == 0 ? null : (T) storage[--index];
    }

    //Unchecked cast: 'java.util.stream.Stream<java.lang.Object>' to 'java.util.stream.Stream<T>'
    Stream<T> stream() {
        return (Stream<T>) Arrays.stream(storage);
    }
}