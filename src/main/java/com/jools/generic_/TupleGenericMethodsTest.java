package com.jools.generic_;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/18 20:08
 */
public class TupleGenericMethodsTest {

    public static void main(String[] args) {

        Tuple2<String, Integer> tupleByF = f();
        System.out.println(tupleByF);   // 返回 二元 Tuple，指定了参数类型
        System.out.println(f2());   // 返回 二元 Tuple；未指定参数类型
        System.out.println(h());    // 返回 三元 Tuple
        System.out.println(k());    // 返回 四元 Tuple
        System.out.println(j());    // 返回 五元 Tuple

        /*
         输出结果:
            Tuple2{a1=hi, a2=48}
            Tuple2{a1=hi, a2=47}
            Tuple2{a1=com.jools.generic_.Amphibian@5010be6, a2=hi}
            Tuple2{a1=com.jools.generic_.Vehicle@238e0d81, a2=com.jools.generic_.Amphibian@31221be2}
            Tuple2{a1=com.jools.generic_.Vehicle@377dca04, a2=com.jools.generic_.Amphibian@728938a9}
        */
    }

    static Tuple2<String, Integer> f() {
        return Tuple.tuple("hi", 48);
    }

    static Tuple2 f2() {
        return Tuple.tuple("hi", 47);
    }

    static Tuple3<Amphibian, String, Integer> h() {
        return Tuple.tuple(new Amphibian(), "hi", 47);
    }

    static Tuple4<Vehicle, Amphibian, String, Integer> k() {
        return Tuple.tuple(new Vehicle(), new Amphibian(), "hi", 47, 11.1);
    }

    static Tuple5<Vehicle, Amphibian, String, Integer, Double> j() {
        return Tuple.tuple(new Vehicle(), new Amphibian(), "jj", 1231, 222.2);
    }
}
