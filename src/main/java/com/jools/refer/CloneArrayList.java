package com.jools.refer;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/5/2 18:10
 * @description: TODO
 */
public class CloneArrayList {

    public static void main(String[] args) {
        ArrayList<Int> v = IntStream.range(0, 10)
                .mapToObj(Int::new)
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println("v: " + v);

        // 克隆
        ArrayList<Int> clone = (ArrayList<Int>) v.clone();
        clone.forEach(Int::increment);
        // 查看是否修改了原本的 v
        System.out.println("v after clone and operate: " + v);
        /*
         输出结果:
            v: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
            v after clone and operate: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
        */
    }
}

class Int {
    private int i;

    public Int(int i) {
        this.i = i;
    }

    public void increment() {
        i++;
    }

    @Override
    public String toString() {
        return Integer.toString(i);
    }
}


