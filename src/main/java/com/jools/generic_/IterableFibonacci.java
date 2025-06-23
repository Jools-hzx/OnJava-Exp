package com.jools.generic_;

import java.util.Iterator;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/18 18:39
 * @description: TODO
 */
public class IterableFibonacci
        extends Fibonacci
        implements Iterable<Integer> {

    // 存储总数目
    private int n;

    public IterableFibonacci(int count) {
        this.n = count;
    }

    // 返回自定义迭代器
    @Override
    public Iterator iterator() {
        return new Iterator() {
            @Override
            public boolean hasNext() {
                return n > 0;
            }

            @Override
            public Object next() {
                n--;
                return IterableFibonacci.this.get();
            }

            @Override
            public void remove() {
                throw new RuntimeException("Unsupported Operation!");
            }
        };
    }

    public static void main(String[] args) {
        // 输出: 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584,
        for (Integer i : new IterableFibonacci(18)) {
            System.out.print(i + ", ");
        }
    }
}
