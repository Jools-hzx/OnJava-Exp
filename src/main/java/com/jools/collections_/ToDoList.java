package com.jools.collections_;

import java.util.PriorityQueue;

/**
 * @author Jools He
 * @date 2025/6/16 19:49
 * @description: TODO
 */

public class ToDoList {
    public static void main(String[] args) {

        PriorityQueue<ToDoItem> toDo = new PriorityQueue<>();
        toDo.add(new ToDoItem('A', 2, "A2"));
        toDo.add(new ToDoItem('B', 4, "B4"));
        toDo.add(new ToDoItem('A', 1, "A1"));
        toDo.add(new ToDoItem('A', 3, "A3"));
        while (!toDo.isEmpty()) {
            System.out.println(toDo.remove());
        }

        /*
         输出:
            A1: A1
            A2: A2
            A3: A3
            B4: B4
        */
    }
}

class ToDoItem implements Comparable<ToDoItem> {

    private char primary;
    private int secondary;
    private String item;

    public ToDoItem(char primary, int secondary, String item) {
        this.primary = primary;
        this.secondary = secondary;
        this.item = item;
    }

    @Override
    public int compareTo(ToDoItem arg) {
        if (primary > arg.primary) {
            return 1;
        }
        if (primary == arg.primary) {
            if (secondary > arg.secondary) {
                return 1;
            } else if (secondary == arg.secondary) {
                return 0;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        return Character.toString(primary) + secondary + ": " + item;
    }
}
