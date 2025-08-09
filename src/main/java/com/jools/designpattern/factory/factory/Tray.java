package com.jools.designpattern.factory.factory;

import java.util.ArrayList;

/**
 * @author Jools He
 * @description: 表示包含了多个 Link 类和 Tray 类的容器
 * Tray 类使用 add 方法将 Link 类的 Tray 类集合在一起。
 */
public abstract class Tray extends Item {

    protected ArrayList<Item> tray = new ArrayList<>();

    public Tray(String caption) {
        super(caption);
    }

    public void add(Item item) {
        tray.add(item);
    }
}
