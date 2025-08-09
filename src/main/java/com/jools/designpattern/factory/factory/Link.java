package com.jools.designpattern.factory.factory;

/**
 * @author Jools He
 * @date 2025/7/27 10:23
 * @description: 抽象零件: 抽象地表示 HTML 的超链接类
 */
public abstract class Link extends Item {

    protected String url;

    public Link(String caption, String url) {
        super(caption);
        this.url = url;
    }
}
