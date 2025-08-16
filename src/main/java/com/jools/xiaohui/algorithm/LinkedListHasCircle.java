package main.java.com.jools.xiaohui.algorithm;

import lombok.Data;

/**
 * @author Jools He
 * @date 2025/8/9 16:30
 * @description: TODO
 */
public class LinkedListHasCircle {

    public static void main(String[] args) {

        Node node1 = new Node(5);
        Node node2 = new Node(3);
        Node node3 = new Node(7);
        Node node4 = new Node(2);
        Node node5 = new Node(6);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node2;

        System.out.println(hasCircle(node1));
        System.out.println(findCircleStart(node1));
    }

    // 查找环的入环节点
    static Node findCircleStart(Node head) {
        Node start = getCircleMeet(head);
        if(null == start) {
            return null;
        }
        Node p1 = start, p2 = head;
        while (p1.val != p2.val) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    // 查找相遇节点
    static Node getCircleMeet(Node h1) {
        Node p1 = h1, p2 = h1;
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1.val == p2.val) {
                return p1;
            }
        }
        return null;
    }

    static boolean hasCircle(Node h1) {
        Node p1 = h1, p2 = h1;
        while (p1 != null && p2 != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1.val == p2.val) {
                return true;
            }
        }
        return false;
    }

    @Data
    static class Node {

        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "Node=[val:" + val + "]";
        }
    }
}
