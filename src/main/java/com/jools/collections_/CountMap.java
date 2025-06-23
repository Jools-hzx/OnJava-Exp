package com.jools.collections_;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/5/5 18:47
 * @description: TODO
 */
public class CountMap extends AbstractMap<Integer, String> {

    private int size;
    private static char[] chars = "SFAWECQWEDASFWEFQREQWS".toCharArray();

    public CountMap(int size) {
        this.size = Math.max(0, size);
    }

    // 负责计算任意键的值;并且在 get() 和 Entry.getValue() 方法内使用
    private static String value(int key) {
        return chars[key % chars.length] + Integer.toString(key / chars.length);
    }

    @Override
    public String get(Object key) {
        return value((Integer) key);
    }

    // 自定义 Entry 继承自 Map.Entry
    private static class Entry implements Map.Entry<Integer, String> {

        int idx;

        Entry(int idx) {
            this.idx = idx;
        }

        @Override
        public Integer getKey() {
            return idx;
        }

        // 通过 idx 访问 chars 内元素
        @Override
        public String getValue() {
            return value(idx);
        }

        @Override
        public String setValue(String value) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Entry entry = (Entry) o;
            return idx == entry.idx;
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(idx);
        }
    }

    @Override
    public Set<Map.Entry<Integer, String>> entrySet() {
        return IntStream.range(0, size)
                .mapToObj(Entry::new)
                .collect(Collectors.
                        toCollection(LinkedHashSet::new));
    }

    public static void main(String[] args) {
        final int size = 6;
        CountMap cm = new CountMap(60);
        System.out.println(cm);
        System.out.println("Key[50] -> Val[" + cm.get(50) + "]");

        // 将所有值输出
        cm.values().stream()
                .limit(size)
                .forEach(System.out::println);
        System.out.println();

        new Random(47).ints(size, 0, 1000)
                .mapToObj(cm::get)
                .forEach(System.out::println);
        /*
         执行结果：
            {0=S0, 1=F0, 2=A0, 3=W0, 4=E0, 5=C0, 6=Q0, 7=W0, 8=E0, 9=D0, 10=A0, 11=S0, 12=F0, 13=W0, 14=E0, 15=F0,
            16=Q0, 17=R0, 18=E0, 19=Q0, 20=W0, 21=S0, 22=S1, 23=F1, 24=A1, 25=W1, 26=E1, 27=C1, 28=Q1, 29=W1, 30=E1,
            31=D1, 32=A1, 33=S1, 34=F1, 35=W1, 36=E1, 37=F1, 38=Q1, 39=R1, 40=E1, 41=Q1, 42=W1, 43=S1, 44=S2, 45=F2,
            46=A2, 47=W2, 48=E2, 49=C2, 50=Q2, 51=W2, 52=E2, 53=D2, 54=A2, 55=S2, 56=F2, 57=W2, 58=E2, 59=F2}
            Key[50] -> Val[Q2]
            S0
            F0
            A0
            W0
            E0
            C0

            Q11
            C25
            S31
            W39
            F43
            S19
        */
    }
}
