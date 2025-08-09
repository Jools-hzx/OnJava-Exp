package com.jools.designpattern.factory.factory;

/**
 * @author Jools He
 * @date 2025/7/27 10:39
 * @description: TODO
 */
public class Main {

    public static void main(String[] args) {

        Factory factory = Factory.getFactory("");
        Link renmin = factory.createLink("人名日报", "http://www.people.com.cn/");
        Link guangmin = factory.createLink("光明日报", "http://www.gmw.cn/");
        Link cnNews = factory.createLink("中国新闻网", "URL_ADDRESS.chinanews.com/");
        Link cnCom = factory.createLink("中国网", "URL_ADDRESS");
        Link google = factory.createLink("Google", "www.google.com");
        Link yahoo = factory.createLink("Yahoo", "www.yahoo.com");

        Tray trayNews = factory.createTray("非官方新闻网");
        trayNews.add(renmin);
        trayNews.add(guangmin);

        Tray trayCn = factory.createTray("官方新闻网");
        trayCn.add(cnNews);
        trayCn.add(cnCom);

        Tray search = factory.createTray("Search");
        search.add(google);
        search.add(yahoo);

        Page page = factory.createPage("LinkPage", "Jools He");
        page.add(trayNews);
        page.add(trayCn);
        page.output();
    }
}
