package com.jools.generic_;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/19 19:17
 * @description: TODO
 */
public class ArrayOfGeneric {

    static final int SIZE = 100;
    static Generic<Integer>[] gia;

    public static void main(String[] args) {

        try {
            gia = (Generic<Integer>[]) new Object[SIZE];
        } catch (Exception e) {
            System.out.println(e.getMessage());
            /*
             输出:  class [Ljava.lang.Object; cannot be cast to class
             [Lcom.jools.generic_.Generic; ([Ljava.lang.Object; is in module java.base of loader 'bootstrap';
             [Lcom.jools.generic_.Generic; is in unnamed module of loader 'app')
            */
        }

        // 运行时的类型是原始类型 (已被擦除)
        gia = (Generic<Integer>[]) new Generic[SIZE];
        System.out.println(gia.getClass().getSimpleName());
        gia[0] = new Generic<>();

//        gia[1] = new Object();
//        gia[2] = new Generic<Double>();
    }
}
