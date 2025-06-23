package com.jools.generic_;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/21 16:25
 * @description: TODO
 */
public class UnboundedWidcards1 {

    static List list1;
    static List<?> list2;
    static List<? extends Object> list3;

    static void assign1(List list) {
        list1 = list;
        list2 = list;
        //Unchecked assignment: 'java.util.List' to 'java.util.List<? extends java.lang.Object>
        list3 = list;
    }

    static void assign2(List<?> list) {
        list1 = list;
        list2 = list;
        list3 = list;
    }

    static void assign3(List<? extends Object> list) {
        list1 = list;
        list2 = list;
        list3 = list;
    }

    public static void main(String[] args) {
        assign1(new ArrayList());
        assign2(new ArrayList());
        assign3(new ArrayList());   // Unchecked assignment: 'java.util.ArrayList' to 'java.util.List<? extends java.lang.Object>'

        assign1(new ArrayList<>());
        assign2(new ArrayList<>());
        assign3(new ArrayList<>());

        // 两种形式都可以作为 List<?> 接受
        List<?> wildList = new ArrayList<>();
        wildList = new ArrayList<>();
        assign2(wildList);
        assign2(wildList);
        assign3(wildList);
    }
}
