package com.jools.designpattern.factory.factory;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Jools He
 * @description: 抽象地表示 HTML 页面的类
 */
public abstract class Page {

    protected String title;
    protected String author;
    protected ArrayList<Item> content = new ArrayList<>();

    public Page(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public void add(Item item) {
        content.add(item);
    }

    public void output() {
        String filename = title + ".html";
        try {
            FileWriter writer = new FileWriter(filename);
            writer.write(this.makeHTML());
            writer.close();
            System.out.println(filename + " 编写完成。");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected abstract String makeHTML();
}
