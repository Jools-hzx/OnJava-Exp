package com.jools.designpattern.handleChain;

import java.util.PriorityQueue;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/6 20:23
 * @description: TODO
 */
public class HandlerDemo {

    public static void main(String[] args) {

        Handler handlerA = new ConcreteHandlerA();
        Handler handlerB = new ConcreteHandlerB();
        // 处理器 A 设置的下一个处理器为 ConcreteHandlerB 实例
        handlerA.setNextHandler(handlerB);
        handlerA.handleRequest("A");
        handlerA.handleRequest("B");
        // 处理器 B 没有设置下一个处理器，所以无法处理请求 "C"
        handlerA.handleRequest("C");


    }
}

// 处理器接口 (抽象 / 接口)
abstract class Handler {

    protected Handler next;

    public void setNextHandler(Handler next) {
        this.next = next;
    }

    public abstract void handleRequest(String req);
}

// 具体处理器 A
class ConcreteHandlerA extends Handler {
    @Override
    public void handleRequest(String req) {
        if ("A".equals(req)) {
            System.out.println("ConcreteHandlerA handled request: " + req);
        } else if (super.next != null) {
            super.next.handleRequest(req);
        } else {
            System.out.println("No handler for request: " + req);
        }
    }
}

// 具体处理器 B
class ConcreteHandlerB extends Handler {

    @Override
    public void handleRequest(String req) {
        if("B".equals(req)) {
            System.out.println("ConcreteHandlerB handled request: " + req);
        } else if(super.next != null) {
            super.next.handleRequest(req);
        } else {
            System.out.println("No handler for request: " + req);
        }
    }
}
