package com.jools.unitTest;

import java.util.ArrayList;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/4 22:32
 * @description: TODO
 */
public class CountedList extends ArrayList<String> {

    private static int counter = 0;
    private int id = counter++;

    public CountedList() {
        System.out.println("CountList-#" + id);
    }

    public int getId() {
        return id;
    }
}
