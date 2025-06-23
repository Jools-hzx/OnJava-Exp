package com.jools.refer;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/5/3 17:58
 * @description: TODO
 */

class IntVal {

    private int n;

    IntVal(int n) {
        this.n = n;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public void increment() {
        n++;
    }

    @Override
    public String toString() {
        return "IntVal{" +
                "n=" + n +
                '}';
    }
}

public class MutableInteger {

    public static void main(String[] args) {
        // 将持有基本数据类型的对象存储到集合；该对象支持修改基础类型
        List<IntVal> v = IntStream
                .range(0, 10)
                .mapToObj(IntVal::new)
                .collect(Collectors.toList());
        System.out.println(v);
        v.forEach(IntVal::increment);
        System.out.println(v);
        /*
         输出结果:
         [IntVal{n=0}, IntVal{n=1}, IntVal{n=2}, IntVal{n=3}, IntVal{n=4}, IntVal{n=5},
          IntVal{n=6}, IntVal{n=7}, IntVal{n=8}, IntVal{n=9}]

         [IntVal{n=1}, IntVal{n=2}, IntVal{n=3}, IntVal{n=4}, IntVal{n=5}, IntVal{n=6}, IntVal{n=7},
           IntVal{n=8}, IntVal{n=9}, IntVal{n=10}]
        */
    }
}
