package com.jools.collections_;

import lombok.Data;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.function.Supplier;

/**
 * @author Jools He
 * @date 2025/6/16 19:57
 * @description: TODO
 */
public class SimpleDeques {

    static void test(Deque<String> deque) {
        CountString c1 = new CountString(), c2 = new CountString(20);
        for (int i = 0; i < 8; i++) {
            deque.offerFirst(c1.get());
            deque.offerLast(c2.get());
        }
        System.out.println(deque);
        StringBuilder result = new StringBuilder();
        while (!deque.isEmpty()) {
            System.out.print(deque.peekFirst() + " ");
            result.append(deque.pollFirst()).append(" ");
            System.out.print(deque.peekLast() + " ");
            result.append(deque.pollLast()).append(" ");
        }
        System.out.println("\n" + result);
    }

    public static void main(String[] args) {
        System.out.println("LinkedList");
        test(new LinkedList<>());

        System.out.println("ArrayDeque");
        test(new ArrayDeque<>());

        System.out.println("LinkedBlockDeque");
        int count = 10;
        test(new LinkedBlockingDeque<>(count)); // 大小有限制;达到其大小限制时停止

        System.out.println("ConcurrentLinkedDeque");
        test(new ConcurrentLinkedDeque<>());

        /*
         输出结果:
         LinkedList
        [7, 6, 5, 4, 3, 2, 1, 0, 20, 21, 22, 23, 24, 25, 26, 27]
        7 27 6 26 5 25 4 24 3 23 2 22 1 21 0 20
        7 27 6 26 5 25 4 24 3 23 2 22 1 21 0 20
        ArrayDeque
        [7, 6, 5, 4, 3, 2, 1, 0, 20, 21, 22, 23, 24, 25, 26, 27]
        7 27 6 26 5 25 4 24 3 23 2 22 1 21 0 20
        7 27 6 26 5 25 4 24 3 23 2 22 1 21 0 20
        LinkedBlockDeque
        [4, 3, 2, 1, 0, 20, 21, 22, 23, 24]
        4 24 3 23 2 22 1 21 0 20
        4 24 3 23 2 22 1 21 0 20
        ConcurrentLinkedDeque
        [7, 6, 5, 4, 3, 2, 1, 0, 20, 21, 22, 23, 24, 25, 26, 27]
        7 27 6 26 5 25 4 24 3 23 2 22 1 21 0 20
        7 27 6 26 5 25 4 24 3 23 2 22 1 21 0 20
        */
    }
}

// 实现 Supplier 返回 n
class CountString implements Supplier<String> {

    private int n = 0;

    public CountString() {
    }

    public CountString(int n) {
        this.n = n;
    }

    @Override
    public String get() {
        return Integer.toString(n++);
    }

    @Override
    public String toString() {
        return String.valueOf(n);
    }
}
