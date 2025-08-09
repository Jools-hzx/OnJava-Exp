package com.jools.designpattern.builder;

/**
 * @author Jools He
 * @description: 声明了编写标题、字符串、条目的方法
 */
public abstract class Builder {

    public abstract void makeTitle(String title);

    public abstract void makeString(String str);

    public abstract void makeItems(String[] items);

    public abstract void close();
}
