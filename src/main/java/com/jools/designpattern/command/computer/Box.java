package com.jools.designpattern.command.computer;

/**
 * @author Jools He
 * @date 2025/7/30 1:53
 * @description: TODO
 */
public class Box {

    /**
     * 开机命令对象
     */
    private Command openCommand;

    /**
     * 设置开机命令对象
     * @param openCommand
     */
    public void setOpenCommand(Command openCommand) {
        this.openCommand = openCommand;
    }

    /**
     * 提供给客户端使用，接受并相应用户请求
     */
    public void openButtonPressed() {
        this.openCommand.execute();
    }
}
