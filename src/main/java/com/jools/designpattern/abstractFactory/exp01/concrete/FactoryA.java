package com.jools.designpattern.abstractFactory.exp01.concrete;

import com.jools.designpattern.abstractFactory.exp01.factory.AbstractProduct;
import com.jools.designpattern.abstractFactory.exp01.factory.Factory;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/1/17 20:25
 * @description: TODO
 */
public class FactoryA extends Factory {
    @Override
    public AbstractProduct manufactureContainer() {
        return new ContainerProductA();
    }

    @Override
    public AbstractProduct manufactureMould() {
        return new MouldProductA();
    }
}
