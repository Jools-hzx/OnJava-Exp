package com.jools.designpattern.factory.tablefactory;

import com.jools.designpattern.factory.factory.Link;

/**
 * @author Jools He
 * @date 2025/7/27 11:10
 * @description: Link 紫萼里，使用 <td> 标签取代 li
 */
public class TableLink extends Link {

    public TableLink(String caption, String url) {
        super(caption, url);
    }

    @Override
    public String makeHTML() {
        return "<td><a href=\"" + url + "\">" + caption + "</a></td>\n";
    }
}
