package com.jools.designpattern.command.cook;

/**
 * @author Jools He
 * @date 2025/7/30 2:12
 * @description: TODO
 */
public class CoolCook implements CookApi{
    @Override
    public void cook(String name) {
        System.out.println("凉菜" + name + "已经做好，本厨师正在装盘");
    }
}
