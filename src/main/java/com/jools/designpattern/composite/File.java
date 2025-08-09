package com.jools.designpattern.composite;

/**
 * @author Jools He
 * @description: 表示文件的类，它是 Entry 类的子类
 */
public class File extends Entry {

    private String name;
    private int size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public int getSize() {
        return 0;
    }

    // 要求实现父类的 printList 方法
    @Override
    protected void printList(String prefix) {
        System.out.println(prefix + "/" + this);
    }
}
