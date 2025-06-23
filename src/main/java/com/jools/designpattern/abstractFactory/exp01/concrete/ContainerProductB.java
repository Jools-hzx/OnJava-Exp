package com.jools.designpattern.abstractFactory.exp01.concrete;

import com.jools.designpattern.abstractFactory.exp01.factory.ContainerProduct;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/1/17 20:19
 * @description: TODO
 */
public class ContainerProductB extends ContainerProduct {
    @Override
    public void show() {
        System.out.println("生产出了容器产品 B");
    }
}
