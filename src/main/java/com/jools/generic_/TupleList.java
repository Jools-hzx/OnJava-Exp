package com.jools.generic_;

import java.util.ArrayList;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/19 16:20
 * @description: TODO
 */
public class TupleList<A, B, C, D>
        extends ArrayList<Tuple4<A, B, C, D>> {

    public static void main(String[] args) {

        TupleList<Vehicle, Amphibian, String, Integer> tl = new TupleList<>();

        // 添加数据类型为 Tuple4<Vehicle, Amphibian, String, Integer> 的元素
        tl.add(TupleTest.h());  // 添加一个
        tl.add(TupleTest.h());  // 添加两个

        tl.forEach(System.out::println);
        /*
         输出结果:
            Tuple2{a1=com.jools.generic_.Vehicle@31221be2, a2=com.jools.generic_.Amphibian@377dca04}
            Tuple2{a1=com.jools.generic_.Vehicle@728938a9, a2=com.jools.generic_.Amphibian@21b8d17c}
        */
    }
}
