package com.jools.designpattern.observer.newspaper;

/**
 * @author Jools He
 * @description: TODO
 */
public class Reader implements Observer{

    private String name;

    // 拉模式
    @Override
    public void update(Subject subject) {
        System.out.println(name + " 收到报纸内容：" + ((NewsPaper)subject).getContent());
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
