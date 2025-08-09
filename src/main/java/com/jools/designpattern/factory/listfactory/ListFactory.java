package com.jools.designpattern.factory.listfactory;

import com.jools.designpattern.factory.factory.Factory;
import com.jools.designpattern.factory.factory.Link;
import com.jools.designpattern.factory.factory.Page;
import com.jools.designpattern.factory.factory.Tray;

/**
 * @author Jools He
 * @description: 具体工厂;
 * 简单地 new 出来 ListLink 类的实例、ListTray 类的实例以及 ListPage 类的实例
 */
public class ListFactory extends Factory {

    @Override
    public Link createLink(String caption, String url) {
        return new ListLink(caption, url);
    }

    @Override
    public Tray createTray(String caption) {
        return new ListTray(caption);
    }

    @Override
    public Page createPage(String title, String author) {
        return new ListPage(title, author);
    }
}
