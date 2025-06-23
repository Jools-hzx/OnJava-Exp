package com.jools.designpattern.trash;

import java.util.List;

/**
 * @author Jools He
 * @date 2025/6/23 3:07
 * @description: TODO
 */
public class FillableList<T extends Trash>
        implements Fillable<T> {

    private List<T> list;

    public FillableList(List<T> list) {
        this.list = list;
    }

    @Override
    public void addTrash(T t) {
        list.add(t);
    }
}
