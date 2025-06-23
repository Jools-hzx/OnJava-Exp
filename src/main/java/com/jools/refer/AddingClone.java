package com.jools.refer;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/5/2 19:10
 * @description: TODO
 */
public class AddingClone {

    public static void main(String[] args) {
        Int2 x = new Int2(10);
        Int2 x2 = x.clone();   // 克隆，深拷贝
        x2.increment();
        System.out.println("x= " + x + ", x2=" + x2);

        Int3 x3 = new Int3(7);
        Int3 x4 = (Int3) x3.clone(); // 克隆，深拷贝
        System.out.println("x3=" + x3 + ", x4=" + x4);

        ArrayList<Int2> v = IntStream.range(0, 10)
                .mapToObj(Int2::new)
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println("v:" + v);

        // 克隆 ArrayList， 暂时为浅拷贝
        ArrayList<Int2> clonedList = (ArrayList<Int2>) v.clone();

        // 深拷贝；克隆每个元素
        IntStream.range(0, v.size())
                .forEach(i -> clonedList.set(i, v.get(i).clone()));
        // 对深拷贝之后的所有 v2 进行累加操作
        clonedList.forEach(Int2::increment);
        System.out.println("v after clone and operate: " + v);
        System.out.println("cloneList after clone and operate" + clonedList);

        /*
         输出结果:
            x= 10, x2=11
            x3=7, x4=7
            v:[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
            v after clone and operate: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
            cloneList after clone and operate[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
        */
    }
}

class Int2 implements Cloneable {

    private int i;

    public Int2(int i) {
        this.i = i;
    }

    public void increment() {
        i++;
    }

    @Override
    public String toString() {
        return Integer.toString(i);
    }

    @Override
    protected Int2 clone() {
        try {
            return (Int2) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}

// 继承不会移除可克隆性
class Int3 extends Int2 {
    public Int3(int i) {
        super(i);
    }
}
