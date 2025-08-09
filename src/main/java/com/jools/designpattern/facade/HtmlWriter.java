package com.jools.designpattern.facade;

import java.io.Writer;

/**
 * @author Jools He
 * @date 2025/7/28 22:54
 * @description: TODO
 */
public class HtmlWriter {

    private Writer writer;

    public HtmlWriter(Writer writer) {
        this.writer = writer;
    }

    public void title(String title) throws Exception {
        writer.write("<html>\n");
        writer.write("<head>\n");
        writer.write("<title>" + title + "</title>\n");
        writer.write("</head>\n");
        writer.write("<body>\n");
        writer.write("<h1>" + title + "</h1>\n");
    }

    // 输出段落
    public void paragraph(String msg) throws Exception {
        writer.write("<p>" + msg + "</p>\n");
    }

    // 输出超链接
    public void link(String href, String caption) throws Exception {
        paragraph("<a href=\"" + href + "\">" + caption + "</a>");
    }

    // 输出邮件地址
    public void mailto(String mailaddr, String username) throws Exception {
        link("mailto:" + mailaddr, username);
    }

    // 结束输出 HTML
    public void close() throws Exception {
        writer.write("</body>\n");
        writer.write("</html>\n");
        writer.close();
    }
}

