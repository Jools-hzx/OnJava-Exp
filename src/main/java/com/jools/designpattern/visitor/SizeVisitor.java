package com.jools.designpattern.visitor;

import java.util.Iterator;

/**
 * @author Jools He
 * @date 2025/7/28 13:31
 * @description: TODO
 */
public class SizeVisitor extends Visitor{

    private int size = 0;

    public int getSize() {
        return size;
    }

    @Override
    public void visit(File file) {
        size += file.getSize();
    }

    @Override
    public void visit(Directory dir) {
        Iterator<Entry> iter = dir.iterator();
        while (iter.hasNext()) {
            Entry entry = iter.next();
            entry.accept(this);
        }
    }
}
