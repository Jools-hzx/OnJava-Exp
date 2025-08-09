package com.jools.designpattern.factory.listfactory;

import com.jools.designpattern.factory.factory.Item;
import com.jools.designpattern.factory.factory.Tray;

import java.util.Iterator;

/**
 * @author Jools He
 * @description: 变量 item 是 Item 类型类；
 * 而 Item 类又声明了 makeHTML 方法; 而且 ListLink 和 ListTray 类都是 Item 子类;
 * 皆可以调用 makeHTML
 */
public class ListTray extends Tray {

    public ListTray(String caption) {
        super(caption);
    }

    @Override
    public String makeHTML() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("<li>\n");
        buffer.append(caption + "\n");
        buffer.append("<ul>\n");
        Iterator<Item> it = tray.iterator();
        while (it.hasNext()) {
            Item item = it.next();
            buffer.append(item.makeHTML());
        }
        buffer.append("</ul>\n");
        buffer.append("</li>\n");
        return buffer.toString();
    }
}
