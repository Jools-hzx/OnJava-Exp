package com.jools.designpattern.singleton;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/1/8 20:21
 * @description: TODO
 */
public class TripleClient {

    public static void main(String[] args) {

        Triple instance01 = Triple.getInstance();
        Triple instance02 = Triple.getInstance();
        Triple instance03 = Triple.getInstance();
        System.out.println(instance01.getNo());
        System.out.println(instance02.getNo());
        System.out.println(instance03.getNo());

        Triple.getInstance();
    }
}
