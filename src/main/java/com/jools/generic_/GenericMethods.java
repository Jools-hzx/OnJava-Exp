package com.jools.generic_;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/18 18:50
 * @description: TODO
 */
public class GenericMethods {

    public <T> void f(T x) {
        System.out.println(x.getClass().getName());
    }

    public static void main(String[] args) {
        GenericMethods gm = new GenericMethods();
        gm.f("");   // java.lang.String
        gm.f(1);    // java.lang.Integer
        gm.f(1.0);  // java.lang.Double
        gm.f(1.0F); // java.lang.Float
        gm.f('c');  // java.lang.Character
        gm.f(gm);   // com.jools.generic_.GenericMethods
    }
}
