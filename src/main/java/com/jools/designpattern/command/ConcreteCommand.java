package com.jools.designpattern.command;

/**
 * @author Jools He
 * @date 2025/7/30 1:18
 * @description: TODO
 */
public class ConcreteCommand implements Command {

    // 持有接收者
    private Receiver receiver = null;

    // 示意，命令对象可以有自己的状态
    private String state;

    public ConcreteCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        // 同错会转调接收者对象的相应方法; 让接收者来真正执行功能
        receiver.action();
    }
}
