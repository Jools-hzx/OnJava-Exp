package com.jools.array;

import java.util.Arrays;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/25 20:39
 * @description: TODO
 */
public class ComparingArrays {

    public static final int SZ = 5;

    static String[][] twoArray() {
        String[][] md = new String[5][];
        Arrays.setAll(md, String[]::new);
        for (int i = 0; i < md.length; i++) {
            for (int j = 0; j < md[i].length; j++) {
                md[i][j] = i * j + "";
            }
        }
        return md;
    }

    public static void main(String[] args) {
        int[] a1 = new int[SZ], a2 = new int[SZ];
        Arrays.setAll(a1, new RandGen.Integer()::get);
        Arrays.setAll(a2, new RandGen.Integer()::get);

        System.out.println("a1 == a2: " + Arrays.equals(a1, a2));   // true
        a2[3] = 1;
        System.out.println("a1.equals(a2): " + Arrays.equals(a1, a2));  // false

        Integer[] boxInts = new Integer[SZ], boxInts2 = new Integer[SZ];
        Arrays.setAll(boxInts, new RandGen.Integer()::get);
        Arrays.setAll(boxInts2, new RandGen.Integer()::get);

        System.out.println("boxInts == boxInts2: " + (boxInts == boxInts2));    // true
        System.out.println("Arryas.equals(boxInts, boxInts2): " + Arrays.equals(boxInts, boxInts2));    // false
        boxInts2[2] = 222;
        System.out.println("Arryas.equals(boxInts, boxInts2): " + Arrays.equals(boxInts, boxInts2));
    }
}
