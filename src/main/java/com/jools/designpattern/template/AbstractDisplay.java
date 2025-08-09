package com.jools.designpattern.template;

/**
 * @author Jools He
 * @date 2025/7/20 11:13
 * @description: 抽象类 AbstractDisplay
 */
public abstract class AbstractDisplay {

    // 交给子类实现的抽象方法 1 open
    public abstract void open();

    // 交给子类去实现的抽象方法 2 print
    public abstract void print();

    // 交给子类去实现的抽象方法 3 close
    public abstract void close();

    // 唯一实现的 display 方法; 首次打开，循环调用 5 次 print; 最后关闭
    public final void display() {
        open();
        for (int i = 0; i < 5; i++) {
            print();
        }
        close();
    }
}
