package com.jools.designpattern.decorator;

/**
 * @author Jools He
 * @description: Border 的子类; SideBorder 类用于指定的字符
 * 实现了 Border 所有的抽象方法； 仅添加左右边界
 */
public class SideBorder extends Border {

    private char borderChar;

    public SideBorder(Display display, char c) {
        super(display);
        this.borderChar = c;
    }

    // 字符数 + 两个边界的长度
    @Override
    public int getColumns() {
        return 1 + display.getColumns() + 1;
    }

    // 即被装饰物的行数
    @Override
    public int getRows() {
        return display.getRows();
    }

    // 指定的一行字符串为被装饰物的字符串
    @Override
    public String getRowText(int row) {
        return borderChar + display.getRowText(row) + borderChar;
    }
}
