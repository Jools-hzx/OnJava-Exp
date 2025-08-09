package com.jools.designpattern.template;

/**
 * @author Jools He
 * @date 2025/7/20 11:28
 * @description: TODO
 */
public class StringDisplay extends AbstractDisplay {

    // 需要显示的字符
    private String str;

    // 以字节为单位计算出的字符串长度
    private int width;

    public StringDisplay(String str) {
        this.str = str;
        this.width = str.getBytes().length;
    }

    // 可见性为 private 只能在本类中被调用; 显示表示方框的角的 '+'
    private void printLine() {
        System.out.print("+");
        for (int i = 0; i < width; i++) {
            // 基于配置的 width 输出 width 个 - 字符
            System.out.print("-");
        }
        System.out.println("+");
    }

    @Override
    public void open() {
        printLine();
    }

    // 重写 print 方法；基于待输出的字符加上 |
    @Override
    public void print() {
        System.out.println("|" + str + "|");
    }

    @Override
    public void close() {
        printLine();
    }
}
