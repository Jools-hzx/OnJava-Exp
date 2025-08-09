package com.jools.designpattern.adapter;

/**
 * @author Jools He
 * @date 2025/7/13 22:46
 * @description: TODO
 */
public class Banner {

    private String string;

    public Banner(String string) {
        this.string = string;
    }

    public void showWithParen() {
        System.out.println("(" + string + ")");
    }

    public void showWithAster() {
        System.out.println("*" + string + "*");
    }
}
