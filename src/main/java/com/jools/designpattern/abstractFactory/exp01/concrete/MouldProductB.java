package com.jools.designpattern.abstractFactory.exp01.concrete;

import com.jools.designpattern.abstractFactory.exp01.factory.MouldProduct;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/1/17 20:20
 * @description: TODO
 */
public class MouldProductB extends MouldProduct {
    @Override
    public void show() {
        System.out.println("生产出了磨具产品 B");
    }
}
