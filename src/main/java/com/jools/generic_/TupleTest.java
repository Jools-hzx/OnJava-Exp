package com.jools.generic_;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/18 17:01
 * @description: TODO
 */
public class TupleTest {

    // 测试元组 2
    static Tuple2<String, Integer> f() {
        // 自动装箱将 int 自动转换为 Integer
        return new Tuple2<>("hi", 47);
    }

    // 测试元组 3
    static Tuple3<Amphibian, String, Integer> g() {
        return new Tuple3<>(new Amphibian(), "hi", 47);
    }

    // 测试元组 4
    static Tuple4<Vehicle, Amphibian, String, Integer> h() {
        return new Tuple4<>(new Vehicle(), new Amphibian(), "hi", 47);
    }

    // 测试元组 5
    static Tuple5<Vehicle, Amphibian, String, Integer, Double> k() {
        return new Tuple5<>(new Vehicle(), new Amphibian(), "hi", 47, 11.1);
    }

    public static void main(String[] args) {
        System.out.println("----- Tuple2 -----");
        Tuple2<String, Integer> f = f();
        System.out.println(f.req());

        System.out.println("----- Tuple3 -----");
        Tuple3<Amphibian, String, Integer> g = g();
        System.out.println(g.req());

        System.out.println("----- Tuple 4 -----");
        Tuple4<Vehicle, Amphibian, String, Integer> h = h();
        System.out.println(h.req());

        System.out.println("----- Tuple 5 -----");
        Tuple5<Vehicle, Amphibian, String, Integer, Double> k = k();
        System.out.println(k.req());

        /*
         输出:
            ----- Tuple2 -----
            hi 47
            ----- Tuple3 -----
            com.jools.generic_.Amphibian@17f052a3 hi, 47
            ----- Tuple 4 -----
            com.jools.generic_.Vehicle@685f4c2e com.jools.generic_.Amphibian@7daf6ecc, hi, d=47
            ----- Tuple 5 -----
            com.jools.generic_.Vehicle@238e0d81 com.jools.generic_.Amphibian@31221be2, hi, d=47, E=11.1
        */
    }
}

class Amphibian {
}

class Vehicle {
}

