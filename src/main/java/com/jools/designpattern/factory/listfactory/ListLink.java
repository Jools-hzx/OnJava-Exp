package com.jools.designpattern.factory.listfactory;

import com.jools.designpattern.factory.factory.Link;

/**
 * @author Jools He
 * @description: Link 子类; 实现父类声明的抽象 makeHTML 抽象方法;
 * ListLink 类使用 <li> 标签和 <a> 标签来制作 HTML 片段
 */
public class ListLink extends Link {

    public ListLink(String caption, String url) {
        super(caption, url);
    }

    @Override
    public String makeHTML() {
        return "  <li><a href=\"" + url + "\">" + caption + "</a></li>\n";
    }
}
