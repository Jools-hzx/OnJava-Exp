package com.jools.generic_;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/18 16:51
 * @description: TODO
 */
public class Tuple2<A, B> {

    public final A a1;
    public final B a2;

    public Tuple2(A a, B b) {
        this.a1 = a;
        this.a2 = b;
    }

    public String req() {
        return a1 + " " + a2;
    }

    @Override
    public String toString() {
        return "Tuple2{" +
                "a1=" + a1 +
                ", a2=" + a2 +
                '}';
    }
}
