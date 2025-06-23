package com.jools.designpattern.decorator.printhelloworld;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/2/4 11:29
 * @description: TODO
 */
public class UpDownBorder extends Border {

    private char upDownChar;
    private String bound;

    public UpDownBorder(Display display, char upDownChar) {
        super(display);
        this.upDownChar = upDownChar;
        this.bound = makeBorder();
    }

    @Override
    public int getColumns() {
        return display.getColumns();    //每一行字符数不变
    }

    @Override
    public int getRows() {
        return display.getRows() + 2;   //新增上下边界
    }

    //重构当前行内容，添加上下边界
    @Override
    public String getRowText(int row) {
        if (row == 0) {                             // 下边框
            return bound;
        } else if (row == display.getRows() + 1) {  // 上边框
            return bound;
        } else {                                    // 其他边框
            return display.getRowText(row - 1);
        }
    }

    // 构建上下边界
    private String makeBorder() {
        int cols = getColumns();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cols; i++) {
            sb.append(upDownChar);
        }
        return sb.toString();
    }
}
