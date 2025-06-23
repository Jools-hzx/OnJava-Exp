package com.jools.collections_;

import java.util.*;

/**
 * @author Jools He
 * @date 2025/6/16 17:21
 * @description: TODO
 */
public class UnsupporedOperaionsInList {

    static void check(String desc, Runnable test) {
        try {
            test.run();
        } catch (Exception e) {
            System.out.println(desc + "(): " + e);
        }
    }

    static void test(String msg, List<String> list) {
        System.out.println("--- " + msg + " ---");
        Collection<String> c = list;
        List<String> subList = list.subList(5, 10);

        // subList 副本
        ArrayList<String> c2 = new ArrayList<>(subList);
        check("retainAll", () -> c.retainAll(c2));
        check("removeAll", () -> c.removeAll(c2));
        check("clear", c::clear);
        check("isEmpty", c::isEmpty);
        check("add", () -> c.add("AAAA"));
        check("addAll", () -> c.addAll(list));

        // List.set() 支持修改值但是不会修改内部结构大小
        check("List.set", () -> list.set(0, "BBBB"));
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("A B C D E F G H I J K L M N O P Q R S T U V W X Y Z".split(" "));
        test("Modifiable Copy", new ArrayList<>(list));
        test("Arrays.asList()", list);
        test("unmodifiableList()", Collections.unmodifiableList(new ArrayList<>(list)));

        /*
        输出结果:
        --- Modifiable Copy ---
        --- Arrays.asList() ---
        retainAll(): java.lang.UnsupportedOperationException: remove
        removeAll(): java.lang.UnsupportedOperationException: remove
        clear(): java.lang.UnsupportedOperationException
        add(): java.lang.UnsupportedOperationException
        addAll(): java.lang.UnsupportedOperationException
        --- unmodifiableList() ---
        retainAll(): java.lang.UnsupportedOperationException
        removeAll(): java.lang.UnsupportedOperationException
        clear(): java.lang.UnsupportedOperationException
        add(): java.lang.UnsupportedOperationException
        addAll(): java.lang.UnsupportedOperationException
        List.set(): java.lang.UnsupportedOperationException
        */
    }
}
