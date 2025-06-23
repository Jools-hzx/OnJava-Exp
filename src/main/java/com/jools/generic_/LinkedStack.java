package com.jools.generic_;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/18 17:17
 * @description: 泛型栈，T 指定节点存储的数据类型
 */
public class LinkedStack<T> {

    public static void main(String[] args) {
        LinkedStack<String> lss = new LinkedStack<>();
        for (String s : "Phasers on stun!".split(" ")) {
            lss.push(s);
        }
        String s;
        while ((s = lss.pop()) != null) {
            System.out.println(s);
        }
        /*
         输出:
            stun!
            on
            Phasers
         */
    }

    private static class Node<U> {
        U item;
        Node<U> next;

        public Node() {
            item = null;
            next = null;
        }

        // 全参构造器: 指定存储数据 + 指向的下一个节点
        public Node(U item, Node<U> next) {
            this.item = item;
            this.next = next;
        }

        // 是否遍历到尾部节点
        boolean end() {
            return item == null && next == null;
        }
    }

    // 末端哨兵节点
    private Node<T> top = new Node<>();

    // 压栈
    public void push(T item) {
        top = new Node<>(item, top);
    }

    // 出栈
    public T pop() {
        T result = top.item;
        // 更新末端指向; 基于末端节点判断是否栈空
        if (!top.end()) {
            top = top.next;
        }
        return result;
    }
}
