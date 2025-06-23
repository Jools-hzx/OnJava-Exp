package com.jools.generic_;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/18 20:03
 * @description: TODO
 */
public class Tuple {

    // 返回元组 <A, B>
    public static <A, B> Tuple2<A, B> tuple(A a, B b) {
        return new Tuple2<>(a, b);
    }

    // 返回元组 <A, B, C>
    public static <A, B, C> Tuple3<A, B, C> tuple(A a, B b, C c) {
        return new Tuple3<>(a, b, c);
    }

    // 返回元组 <A, B, C, D>
    public static <A, B, C, D> Tuple4<A, B, C, D> tuple(A a, B b, C c, D d) {
        return new Tuple4<>(a, b, c, d);
    }

    // 返回元组 <A, B, C, D>
    public static <A, B, C, D, E> Tuple5<A, B, C, D, E> tuple(A a, B b, C c, D d, E e) {
        return new Tuple5<>(a, b, c, d, e);
    }
}
