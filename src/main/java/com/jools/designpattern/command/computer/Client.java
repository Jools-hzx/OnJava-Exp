package com.jools.designpattern.command.computer;

/**
 * @desc: TODO
 */
public class Client {

    public static void main(String[] args) {

        // 1. 命令和真正的实现组合起来，相当于在组装机器
        GigaMainBoard mainBoard = new GigaMainBoard();
        // 绑定 Command 到 Receiver
        OpenCommand openCommand = new OpenCommand(mainBoard);

        // 2. 为机箱上的按钮i设置对应的命令
        Box box = new Box();
        // Invoker 设置好命令
        box.setOpenCommand(openCommand);

        // 3. 模拟按下机箱上的按钮
        box.openButtonPressed();
    }
}
