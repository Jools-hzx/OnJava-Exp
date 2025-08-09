package com.jools.designpattern.factory.tablefactory;

import com.jools.designpattern.factory.factory.Factory;
import com.jools.designpattern.factory.factory.Link;
import com.jools.designpattern.factory.factory.Page;
import com.jools.designpattern.factory.factory.Tray;

/**
 * @author Jools He
 * @date 2025/7/27 11:08
 * @description: TODO
 */
public class TableFactory extends Factory {
    @Override
    public Link createLink(String caption, String url) {
        return new TableLink(caption, url);
    }

    @Override
    public Tray createTray(String caption) {
        return new TableTray(caption);
    }

    @Override
    public Page createPage(String title, String author) {
        return new TablePage(title, author);
    }
}
