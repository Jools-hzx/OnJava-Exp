package com.jools.designpattern.template;

/**
 * @author Jools He
 * @date 2025/7/20 11:21
 * @description: TODO
 */
public class CharDisplay extends AbstractDisplay {

    // 持有需要显示的字符
    private char ch;

    public CharDisplay(char ch) {
        this.ch = ch;
    }

    // 重写抽象方法; 显示开始字符
    @Override
    public void open() {
        System.out.print("<<");
    }

    // 重写抽象方法; 显示保存的 ch 字符
    @Override
    public void print() {
        System.out.print(ch);
    }

    // 重写抽象方法; 显示结束字符
    @Override
    public void close() {
        System.out.println(">>");
    }
}
