package com.jools.designpattern.bridge;

/**
 * @author Jools He
 * @description: 抽象类,声明了 rawOpen, rawPrint 和 rawClose 三个抽象方法
 */
public abstract class DisplayImpl {

    public abstract void rawOpen();

    public abstract void rawPrint();

    public abstract void rawClose();
}
