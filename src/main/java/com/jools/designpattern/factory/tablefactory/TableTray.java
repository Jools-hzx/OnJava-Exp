package com.jools.designpattern.factory.tablefactory;

import com.jools.designpattern.factory.factory.Item;
import com.jools.designpattern.factory.factory.Tray;

import java.util.Iterator;

/**
 * @author Jools He
 * @date 2025/7/27 11:11
 * @description: Tray 类的子类, 使用 <td> 和 <table> 标签来输出 Item
 */
public class TableTray extends Tray {


    public TableTray(String caption) {
        super(caption);
    }

    @Override
    public String makeHTML() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("<td>");
        buffer.append("<table width=\"100%\" border=\"1\"><tr>");
        buffer.append("<td bgcolor=\"#cccccc\" align=\"center\" colspan=\"" + tray.size() + "\"><b>" + caption + "</b></td>");
        buffer.append("</tr>\n");
        buffer.append("<tr>\n");
        Iterator<Item> it = tray.iterator();
        while (it.hasNext()) {
            Item item = (Item) it.next();
            buffer.append(item.makeHTML());
        }
        buffer.append("</tr></table>");
        buffer.append("</td>");
        return buffer.toString();
    }
}
