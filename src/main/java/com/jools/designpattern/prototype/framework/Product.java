package com.jools.designpattern.prototype.framework;

/**
 * @author Jools He
 * @date 2025/7/26 15:49
 * @description: 实现 “复制” 功能
 */
public interface Product extends Cloneable{

    /**
     * 用于使用方法，具体如何使用，交给 ⌈ 子类 ⌋ 去实现
     * @param s
     */
    void use(String s);

    /**
     * 用于复制实例的方法
     * @return
     */
    Product createClone();
}
