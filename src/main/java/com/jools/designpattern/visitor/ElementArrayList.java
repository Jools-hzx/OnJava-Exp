package com.jools.designpattern.visitor;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Jools He
 * @date 2025/7/28 13:52
 * @description: TODO
 */
public class ElementArrayList extends ArrayList<Entry> implements Element {

    @Override
    public void accept(Visitor v) {
        Iterator<Entry> it = iterator();
        while (it.hasNext()) {
            Entry entry = it.next();
            entry.accept(v);
        }
    }
}
