package com.jools.designpattern.command.cook;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Jools He
 * @date 2025/7/30 2:16
 * @description: TODO
 */
public class MenuCommand implements Command{

    /**
     * 记录组合本菜单的多道菜品也就是多个命令对象
     */
    private Collection<Command> col = new ArrayList<>();

    public void addCommand(Command command) {
        this.col.add(command);
    }

    @Override
    public void execute() {
        for (Command command : col) {
            command.execute();
        }
    }
}
