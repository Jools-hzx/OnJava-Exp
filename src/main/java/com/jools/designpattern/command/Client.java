package com.jools.designpattern.command;

/**
 * @desc: TODO
 */
public class Client {

    /**
     * 示意,负责创建命令对象;并且设定它的接收者
     */
    public void assemble() {
        // 创建接收者
        Receiver receiver = new Receiver();
        // 创建命令对象，设定它的接收者
        ConcreteCommand command = new ConcreteCommand(receiver);
        // 创建 Invoker, 设置命令
        Invoker invoker = new Invoker();
        invoker.setCommand(command);
    }
}
