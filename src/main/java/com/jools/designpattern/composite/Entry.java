package com.jools.designpattern.composite;

/**
 * @author Jools He
 * @description: 表示条目的抽象类
 * add 方法: 向文件夹放入文件和文件夹
 */
public abstract class Entry {

    // 获取名字
    public abstract String getName();

    // 获取大小
    public abstract int getSize();

    public Entry add(Entry entry) throws FileTreatmentException {
        throw new FileTreatmentException();
    }

    // 外部可以直接调用 printList 方法
    public void printList() {
        printList("");
    }

    // 定义方法的方式为: 重载
    protected abstract void printList(String s);

    @Override
    public String toString() {
        return getName() + "(" + getSize() + ")";
    }
}
