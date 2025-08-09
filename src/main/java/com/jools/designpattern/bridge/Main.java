package com.jools.designpattern.bridge;

/**
 * @author Jools He
 * @date 2025/7/27 12:19
 * @description: TODO
 */
public class Main {

    public static void main(String[] args) {

        TriLineDisplay d4 = new TriLineDisplay(new TriStrDisplayImpl("<", "*", ">"));
        d4.triDisplay(5);

        /*
            输出结果:
            <*>
            <**>
            <***>
            <****>
            <*****>
        */
    }
}
