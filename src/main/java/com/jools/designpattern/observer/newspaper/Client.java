package com.jools.designpattern.observer.newspaper;

/**
 * @author Jools He
 * @date 2025/7/29 12:31
 * @description: TODO
 */
public class Client {

    public static void main(String[] args) {
        // 创建一个报纸作为观察者
        NewsPaper subject = new NewsPaper();

        // 创建阅读者也是观察者
        Reader reader1 = new Reader();
        reader1.setName("张三");

        Reader reader2 = new Reader();
        reader2.setName("李四");

        Reader reader3 = new Reader();
        reader3.setName("王五");

        // 注册阅读者
        subject.attach(reader1);
        subject.attach(reader2);
        subject.attach(reader3);

        // 发布报纸
        subject.setContent("本期内容是观察者模式");
    }
}
