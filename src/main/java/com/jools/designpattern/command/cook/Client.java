package com.jools.designpattern.command.cook;

/**
 * @author Jools He
 * @date 2025/7/30 2:21
 * @description: TODO
 */
public class Client {

    public static void main(String[] args) {
        Waiter waiter = new Waiter();

        // 创建命令对象
        Command cmd1 = new DuckCommand();
        Command cmd2 = new ChopCommand();
        Command cmd3 = new PorkCommand();

        // 点菜
        waiter.orderDish(cmd1);
        waiter.orderDish(cmd2);
        waiter.orderDish(cmd3);

        // 点菜完毕
        waiter.orderOver();
    }
}
