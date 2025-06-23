package com.jools.array;

import java.util.Arrays;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/25 18:22
 * @description: TODO
 */
public class TestRandGen {

    static final int SZ = 5;

    public static void main(String[] args) {

        System.out.println("RandGen.Boolean");
        Boolean[] a1 = new Boolean[SZ];
        Arrays.setAll(a1, new RandGen.Boolean()::get);
        ArrayShow.show(a1);

        System.out.println("RandGen.Pint");
        int[] pInts = new int[SZ];
        Arrays.setAll(pInts, new RandGen.Pint()::get);
        ArrayShow.show(pInts);

        System.out.println("RandGen.Integer");
        int[] ints = new int[SZ];
        Arrays.setAll(ints, new RandGen.Integer()::get);
        ArrayShow.show(ints);
    }
}
