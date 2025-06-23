package com.jools.refer;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/5/3 18:06
 * @description: TODO
 */
public class Immutable1 {

    private int date;

    public Immutable1(int date) {
        this.date = date;
    }

    public int read() {
        return date;
    }

    public boolean nonzero() {
        return date != 0;
    }

    public Immutable1 multi(int multiplier) {
        return new Immutable1(date * multiplier);
    }

    public static void f(Immutable1 i1) {
        Immutable1 quad = i1.multi(4);
        System.out.println("i1 = " + quad.read());
        System.out.println("quad = " + quad.read());
    }

    public static void main(String[] args) {
        Immutable1 x = new Immutable1(47);
        System.out.println("x = " + x.read());
        f(x);
        System.out.println(x.nonzero());
        System.out.println("x = " + x.read());

        /*
         输出结果:
            x = 47
            i1 = 188
            quad = 188
            true
            x = 47
        */
    }
}
