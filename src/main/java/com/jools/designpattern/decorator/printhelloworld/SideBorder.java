package com.jools.designpattern.decorator.printhelloworld;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/2/4 10:18
 * @description: TODO
 */
public class SideBorder extends Border {

    private char borderChar;

    protected SideBorder(Display display, char c) {
        super(display);
        this.borderChar = c;
    }

    // 获取列数，原字符 + 左右边框字符
    @Override
    public int getColumns() {
        return display.getColumns() + 2;
    }

    @Override
    public int getRows() {
        return display.getRows();
    }

    // 获取当前行的内容
    @Override
    public String getRowText(int row) {
        return borderChar + display.getRowText(row) + borderChar;
    }
}
