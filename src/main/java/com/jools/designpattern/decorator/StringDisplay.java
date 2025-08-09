package com.jools.designpattern.decorator;

/**
 * @author Jools He
 * @date 2025/7/27 18:54
 * @description: TODO
 */
public class StringDisplay extends Display {

    // 要显示的字符串
    private String str;

    public StringDisplay(String str) {
        this.str = str;
    }

    // 获取字符数目
    @Override
    public int getColumns() {
        return str.getBytes().length;
    }

    @Override
    public int getRows() {
        return 1;
    }

    @Override
    public String getRowText(int row) {
        if (row == 0) {
            return str;
        } else {
            return null;
        }
    }
}
