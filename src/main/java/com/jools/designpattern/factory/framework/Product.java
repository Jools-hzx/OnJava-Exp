package com.jools.designpattern.factory.framework;

/**
 * @author Jools He
 * @date 2025/7/25 21:55
 * @description: 表示产品的类
 * 仅声明了 use 抽象方法
 * use 方法的实现被交给 Product 的子类
 */
public abstract class Product {

    public abstract void use();
}
