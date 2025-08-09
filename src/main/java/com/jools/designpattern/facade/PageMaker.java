package com.jools.designpattern.facade;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Jools He
 * @date 2025/7/28 22:56
 * @description: 使用了 Database 类和 HtmlWriter 类来生成指定用户的 Web 页面
 */
public class PageMaker {

    private PageMaker() {}

    public static void makeWelcomePage(String mailaddr, String filename) throws Exception {
        try {
            Properties mailprops = DataBase.getProperties("maildata");
            String username = mailprops.getProperty(mailaddr);
            HtmlWriter writer = new HtmlWriter(new FileWriter(filename));
            writer.title("Welcome to " + username + "'s page!");
            writer.paragraph("Welcome to " + username + "'s page!");
            writer.paragraph("I'm glad to see you!");
            writer.mailto(mailaddr, username);
            writer.close();
            System.out.println(filename + " is created for " + mailaddr + " (" + username + ")");
        } catch (IOException e) {
            throw new Exception("fail to create HTML");
        }
    }
}
