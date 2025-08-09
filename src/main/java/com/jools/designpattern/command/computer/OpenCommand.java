package com.jools.designpattern.command.computer;

/**
 * @author Jools He
 * @date 2025/7/30 1:47
 * @description: TODO
 */
public class OpenCommand implements Command{

    /**
     * 真正实现命令的是接收者 - 主板
     */
    private MainBoardApi mainBoardApi;

    /**
     * 构造方法;传入主板对象
     */
    public OpenCommand(MainBoardApi mainBoardApi) {
        this.mainBoardApi = mainBoardApi;
    }

    @Override
    public void execute() {
        // 命令对象通知，实际操作需要由 Recevier 主板完成
        this.mainBoardApi.open();
    }
}
