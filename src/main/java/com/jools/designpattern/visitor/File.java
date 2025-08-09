package com.jools.designpattern.visitor;

/**
 * @author Jools He
 * @description: accept 方法的参数是 Visitor 类
 * Visitor 方法被重载了，此处调用的是 visit(File)
 * 这里的 this 是 File 类的实例
 */
public class File extends Entry {

    private String name;
    private int size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        return size;
    }
}
