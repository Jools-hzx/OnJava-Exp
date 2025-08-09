package com.jools.designpattern.command.cook;

/**
 * @author Jools He
 * @date 2025/7/30 2:11
 * @description: TODO
 */
public class HotCook implements CookApi{
    @Override
    public void cook(String name) {
        System.out.println("本厨师正在制作: " + name);
    }
}
