package com.jools.designpattern.factory.tablefactory;

import com.jools.designpattern.factory.factory.Item;
import com.jools.designpattern.factory.factory.Page;

/**
 * @author Jools He
 * @description: Page 子类;
 */
public class TablePage extends Page {

    public TablePage(String title, String author) {
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
        buffer.append("<table width=\"80%\" border=\"3\">\n");
        for (Item item : content) {
            buffer.append(item.makeHTML());
        }
        buffer.append("</table>\n");
        buffer.append("<hr><address>").
                append(author).
                append("</address>");
        buffer.append("</body></html>\n");
        return buffer.toString();
    }
}
