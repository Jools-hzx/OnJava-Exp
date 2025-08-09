package com.jools.designpattern.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jools He
 * @description: 文件夹的类
 */
public class Directory extends Entry {

    // 目录名称
    private String name;

    // 文件夹中的目录条目或者集合
    private List<Entry> directory = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        int size = 0;
        for (Entry entry : directory) {
            size += entry.getSize();
        }
        return size;
    }

    // 重写 - 增加目录条目
    @Override
    public Entry add(Entry entry) {
        directory.add(entry);
        return this;
    }

    @Override
    protected void printList(String prefix) {
        System.out.println(prefix + "/" + this);
        for (Entry entry : directory) {
            entry.printList(prefix + "/" + name);
        }
    }
}
