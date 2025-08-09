package com.jools.designpattern.bridge;

/**
 * @author Jools He
 * @description: 功能是抽象的
 * 负责 "显示一些东西" 该类位于 "显示类层次结构的顶端"
 */
public class Display {

    private DisplayImpl impl;
    private TriDisplayImpl triImpl;

    public Display(DisplayImpl impl) {
        this.impl = impl;
    }

    public Display(TriDisplayImpl triImpl) {
        this.triImpl = triImpl;
    }

    public void open() {
        impl.rawOpen();
    }

    public void print() {
        impl.rawPrint();
    }

    public void close() {
        impl.rawClose();
    }

    public final void display() {
        open();
        print();
        close();
    }

    public final void triDisplay(int times) {
        triImpl.printTriLine(times);
    }
}
