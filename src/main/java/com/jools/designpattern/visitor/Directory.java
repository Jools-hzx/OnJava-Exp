package com.jools.designpattern.visitor;

import com.jools.designpattern.composite.FileTreatmentException;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Jools He
 * @desc: 表示文件夹的类
 * iterator 返回 Iterator 可以用来遍历文件夹内的所有目录条目
 * accept 方法，调用的是 visit(Directory)
 */
public class Directory extends Entry {

    // 文件夹名称
    private String name;

    // 目录条目集合
    private ArrayList<Entry> dir = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    // 获取名字
    @Override
    public String getName() {
        return name;
    }

    // 增加 Directory 内的条目数
    @Override
    public Entry add(Entry entry) throws FileTreatmentException {
        dir.add(entry);
        return this;
    }

    // 生成 Iterator
    @Override
    public Iterator<Entry> iterator() throws FileTreatmentException {
        return dir.iterator();
    }

    // 获取大小
    @Override
    public int getSize() {
        SizeVisitor v = new SizeVisitor();
        accept(v);
        return v.getSize();
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
