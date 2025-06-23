package com.jools.refer;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/5/2 17:57
 * @description: TODO
 */
public class Alias1 {

    private int i;

    public Alias1(int i) {
        this.i = i;
    }

    public static void main(String[] args) {
        Alias1 x = new Alias1(7);
        Alias1 y = x;
        System.out.println("x: " + x.i);
        System.out.println("y: " + y.i);
        System.out.println("Incrementing x");
        x.i++;
        System.out.println("x: " + x.i);
        System.out.println("y: " + y.i);
        /*
         输出结果:
            x: 7
            y: 7
            Incrementing x
            x: 8
            y: 8
        */
    }
}
