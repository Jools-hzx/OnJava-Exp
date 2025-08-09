package com.jools.designpattern.decorator;

/**
 * @author Jools He
 * @date 2025/7/27 19:06
 * @description: Border 子类；在四面八方都加上边框
 */
public class FullBorder extends Border {

    protected FullBorder(Display display) {
        super(display);
    }

    @Override
    public int getColumns() {
        return 1 + display.getColumns() + 1;
    }

    @Override
    public int getRows() {
        return 1 + display.getRows() + 1;
    }

    @Override
    public String getRowText(int row) {
        if (row == 0) {
            // 打印顶部边界
            return "+" + makeLine('-', display.getColumns()) + "+";
        } else if (row == display.getRows() + 1) {
            // 打印底部边界
            return "+" + makeLine('-', display.getColumns()) + "+";
        } else {
            // 打印内容
            return "|" + display.getRowText(row - 1) + "|";
        }
    }

    private String makeLine(char c, int count) {
        return String.valueOf(c).repeat(Math.max(0, count));
    }
}
