package com.jools.designpattern.visitor;

import com.jools.designpattern.composite.FileTreatmentException;

import java.util.Iterator;

/**
 * @author Jools He
 * @desc: TODO
 */
public abstract class Entry implements Element {

    // 获取名字
    public abstract String getName();

    // 获取大小
    public abstract int getSize();

    // 添加条目
    public Entry add(Entry entry) throws FileTreatmentException {
        throw new FileTreatmentException();
    }

    // 生成 Iterator
    public Iterator iterator() throws FileTreatmentException {
        throw new FileTreatmentException();
    }

    @Override
    public String toString() {
        return getName() + " (" + getSize() + ")";
    }
}
