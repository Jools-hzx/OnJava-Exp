package com.jools.designpattern.builder;

/**
 * @author Jools He
 * @date 2025/7/26 19:34
 * @description: TODO
 */
public class Director {

    private Builder builder;

    // 向上转型，传入的是实现 Builder 抽象类的子类
    public Director(Builder builder) {
        this.builder = builder;
    }

    // 定义流程
    public void construct() {
        builder.makeTitle("Greeting");
        builder.makeString("上午 ~ 下午");
        builder.makeItems(
                new String[]{
                        "早上好。",
                        "下午好。"
                });
        builder.makeString(" 晚上");
        builder.makeItems(new String[]{
                "晚上好。",
                "晚安。",
                "再见。"
        });
        builder.close();
    }
}
