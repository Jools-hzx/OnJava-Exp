package com.jools.designpattern.factory.factory;

/**
 * @author Jools He
 * @date 2025/7/27 10:21
 * @description: Link 和 Tray 类的父类
 */
public abstract class Item {

    // 表示标题
    protected String caption;

    public Item(String caption) {
        this.caption = caption;
    }

    public abstract String makeHTML();
}
