package com.jools.designpattern.abstractFactory.exp01;

import com.jools.designpattern.abstractFactory.exp01.concrete.FactoryA;
import com.jools.designpattern.abstractFactory.exp01.concrete.FactoryB;
import com.jools.designpattern.abstractFactory.exp01.factory.Factory;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/1/17 20:27
 * @description: TODO
 */
public class Main {

    public static void main(String[] args) {

        Factory factoryA = new FactoryA();
        Factory factoryB = new FactoryB();

        //A厂生产容器 A
        factoryA.manufactureContainer().show();
        //A厂需要磨具 A
        factoryA.manufactureMould().show();

        //B 厂生产容器B
        factoryB.manufactureContainer().show();
        //B 厂生产磨具 B
        factoryB.manufactureMould().show();

        /*
         输出:
            生产除了容器产品 A
            生产出了磨具产品 A
            生产出了容器产品 B
            生产出了磨具产品 B
         */
    }
}
