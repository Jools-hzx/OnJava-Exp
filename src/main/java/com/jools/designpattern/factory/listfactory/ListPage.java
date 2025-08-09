package com.jools.designpattern.factory.listfactory;

import com.jools.designpattern.factory.factory.Item;
import com.jools.designpattern.factory.factory.Page;

/**
 * @author Jools He
 * @description: Page 子类
 * ListPage 将字段中保存的内容输出成为 HTML 格式;
 * 作者名 author 使用 <address> 输出
 */
public class ListPage extends Page {

    public ListPage(String title, String author) {
        super(title, author);
    }

    @Override
    protected String makeHTML() {

        StringBuffer buffer = new StringBuffer();

        buffer.append("<html><head><title>").
                append(title).
                append("</title></head>\n");
        buffer.append("<body>\n");
        buffer.append("<h1>").
                append(title).
                append("</h1>\n");
        buffer.append("<ul>\n");

        for (Item item : content) {
            buffer.append(item.makeHTML());
        }

        buffer.append("</ul>\n");
        buffer.append("<hr><address>").
                append(author).
                append("</address>");
        buffer.append("</body></html>\n");

        return buffer.toString();
    }
}
