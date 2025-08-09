package com.jools.designpattern.factory.factory;

/**
 * @author Jools He
 * @description: 通过调用 Class 类的 forName 方法来动态地读取类信息
 */
public abstract class Factory {

    public static Factory getFactory(String clsName) {
        Factory factory = null;
        try {
            factory = (Factory) Class.forName(clsName).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return factory;
    }

    public abstract Link createLink(String caption, String url);

    public abstract Tray createTray(String caption);

    public abstract Page createPage(String title, String author);
}
