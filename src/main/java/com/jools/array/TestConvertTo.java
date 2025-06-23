package com.jools.array;

import java.util.Arrays;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/25 18:35
 * @description: TODO
 */
public class TestConvertTo {

    static final int SIZE = 6;

    public static void main(String[] args) {

        Boolean[] a1 = new Boolean[SIZE];
        Arrays.setAll(a1, new RandGen.Boolean()::get);
        boolean[] toPboolean = ConvertTo.primitive(a1);
        ArrayShow.show(toPboolean);
        a1 = ConvertTo.boxed(toPboolean);

        Integer[] a2 = new Integer[SIZE];
        Arrays.setAll(a2, new RandGen.Integer()::get);
        int[] toPInt = ConvertTo.primitive(a2);
        ArrayShow.show(toPInt);
        a2 = ConvertTo.boxed(toPInt);
    }
}
