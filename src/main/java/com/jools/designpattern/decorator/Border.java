package com.jools.designpattern.decorator;

/**
 * @author Jools He
 * @date 2025/7/27 18:56
 * @description: 装饰边框的抽象类; 表示的是装饰边框，也是 Display 的子类
 * 通过继承，装饰边框与被装饰物具有了相同的方法
 */
public abstract class Border extends Display{

    // 被装饰的物品; 可以承载任何 Border 的子类;
    protected Display display;

    protected Border(Display display) {
        this.display = display;
    }
}
