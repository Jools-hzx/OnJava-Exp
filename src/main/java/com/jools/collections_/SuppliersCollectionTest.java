package com.jools.collections_;

import com.jools.generic_.Suppliers;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/5/5 16:31
 * @description: TODO
 */

class Government implements Supplier<String> {

    @Override
    public String get() {
        return foundation[idx++];
    }

    private int idx;

    static String[] foundation = ("dfa awer  asdfaa ewq asfda w safasf, qwerqw, csaweq r w as afwee q")
            .split("\\s+");
}

public class SuppliersCollectionTest {

    public static void main(String[] args) {

        // 借助 Suppliers 生成集合并填充初始元素
        Set<String> set = Suppliers.create(LinkedHashSet::new, new Government(), 10);
        System.out.println(set);

        List<String> list = Suppliers.create(LinkedList::new, new Government(), 10);
        System.out.println(list);

        list = new ArrayList<>();
        Suppliers.fill(list, new Government(), 10);
        System.out.println(list);

        // 使用流
        Set<String> strsToSet = Arrays.stream(Government.foundation).collect(Collectors.toSet());
        System.out.println(strsToSet);

        // 使用流生成 ArrayList
        List<String> strsToList = Arrays.stream(Government.foundation).toList();
        System.out.println(strsToList);

        // 流生成 LinkedList
        List<String> strsToLinkedList = Arrays.stream(Government.foundation)
                .collect(Collectors.toCollection(LinkedList::new));
        System.out.println(strsToLinkedList);

        // 流生成 LinkedHashSet
        set = Arrays.stream(Government.foundation)
                .collect(Collectors.toCollection(LinkedHashSet::new));
        System.out.println(set);

        /*
         执行结果:
            [dfa, awer, asdfaa, ewq, asfda, w, safasf,, qwerqw,, csaweq, r]
            [dfa, awer, asdfaa, ewq, asfda, w, safasf,, qwerqw,, csaweq, r]
            [dfa, awer, asdfaa, ewq, asfda, w, safasf,, qwerqw,, csaweq, r]
            [csaweq, qwerqw,, safasf,, awer, q, r, as, afwee, w, asdfaa, asfda, dfa, ewq]
            [dfa, awer, asdfaa, ewq, asfda, w, safasf,, qwerqw,, csaweq, r, w, as, afwee, q]
            [dfa, awer, asdfaa, ewq, asfda, w, safasf,, qwerqw,, csaweq, r, w, as, afwee, q]
            [dfa, awer, asdfaa, ewq, asfda, w, safasf,, qwerqw,, csaweq, r, as, afwee, q]
        */
    }
}
