package com.jools.designpattern.mediator;

/**
 * @author Jools He
 * @date 2025/7/29 1:11
 * @description: TODO
 */
public class CDDriver extends Colleague{

    public CDDriver(Mediator mediator) {
        super(mediator);
    }

    // 光驱读取出来的数据
    private String date = "";

    // 获取光驱读取出来的数据
    public String getData() {
        return date;
    }

    // 读取光盘
    public void readCD() {
        // 逗号前是视频显示的数据，逗号后是声音
        this.date = "设计模式, 2025-07-29";
        // 通知主板，自己的状态改变了
        getMediator().changed(this);
    }
}
