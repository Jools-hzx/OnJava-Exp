package com.jools.designpattern.observer_;

/**
 * @author Jools He
 * @date 2025/6/23 0:51
 * @description: 用于传递数据的类
 */
public class Message {

    String msg = "";
    int leftCount = 0;

    public Message(String msg, int leftCount) {
        this.msg = msg;
        this.leftCount = leftCount;
    }
}
