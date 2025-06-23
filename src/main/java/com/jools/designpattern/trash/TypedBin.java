package com.jools.designpattern.trash;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jools He
 * @date 2025/6/23 13:46
 * @description: 双路分发 - 新层次结构 TypedBin;
 * add() 采用重载的方式实现：接收不同类型的 Trash
 */
public class TypedBin {

    private List<Trash> typedBin = new ArrayList<>();

    public final String type;

    public TypedBin(String type) {
        this.type = type;
    }

    public List<Trash> bin() {
        // Returns a copy of typedBin:
        return new ArrayList<>(typedBin);
    }

    protected boolean addIt(Trash t) {
        typedBin.add(t);
        return true;
    }

    public boolean add(Aluminum a) {
        return false;
    }

    public boolean add(Paper a) {
        return false;
    }

    public boolean add(Glass a) {
        return false;
    }

    public boolean add(Cardboard a) {
        return false;
    }

    // 新增 Plasitc 分发
    public boolean add(Plastic a) {
        return false;
    }
}
