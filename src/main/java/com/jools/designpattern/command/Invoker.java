package com.jools.designpattern.command;

/**
 * @desc: 调用者
 */
public class Invoker {

    /**
     * 持有命令对象
     */
    private Command command = null;

    /**
     * 设置调用者持有的命令对象
     */
    public void setCommand(Command c) {
        this.command = c;
    }

    /**
     * 示意方法，调用者需要请求命令对象执行请求
     */
    public void action() {
        this.command.execute();
    }
}
