package com.jools.designpattern.trash;

public interface Fillable<T extends Trash> {
    void addTrash(T t);
}
