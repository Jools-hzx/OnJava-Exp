package com.jools.generic_;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/18 16:58
 * @description: TODO
 */
public class Tuple3<A, B, C> extends Tuple2<A, B> {

    public final C c;

    public Tuple3(A a, B b, C c) {
        super(a, b);
        this.c = c;
    }

    @Override
    public String req() {
        return super.req() + ", " + c;
    }
}


class Tuple4<A, B, C, D> extends Tuple3<A, B, C> {

    public final D d;

    public Tuple4(A a, B b, C c, D d) {
        super(a, b, c);
        this.d = d;
    }

    @Override
    public String req() {
        return super.req() + ", d=" + d;
    }
}

class Tuple5<A, B, C, D, E> extends Tuple4<A, B, C, D> {

    public final E e;

    public Tuple5(A a, B b, C c, D d, E e) {
        super(a, b, c, d);
        this.e = e;
    }

    @Override
    public String req() {
        return super.req() + ", E=" + e;
    }
}