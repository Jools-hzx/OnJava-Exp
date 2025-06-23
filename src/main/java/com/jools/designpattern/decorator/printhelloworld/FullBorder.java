package com.jools.designpattern.decorator.printhelloworld;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/2/4 10:24
 * @description: TODO
 */
public class FullBorder extends Border {

    protected FullBorder(Display display) {
        super(display);
    }

    @Override
    public int getColumns() {       // 列数(字符数) 为被装饰物加上两侧边框字符数
        return this.display.getColumns() + 2;
    }

    @Override
    public int getRows() {          // 行数为内容行 + 上下边框
        return this.display.getRows() + 2;
    }

    @Override
    public String getRowText(int row) {         // 指定获取哪一行的字符串
        if (row == 0) {                             // 下边框
            return "+" + makeLine('-', display.getColumns()) + "+";
        } else if (row == display.getRows() + 1) {  // 上边框
            return "+" + makeLine('-', display.getColumns()) + "+";
        } else {                                    // 其他边框
            return "|" + display.getRowText(row - 1) + "|";
        }
    }

    private String makeLine(char c, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(c);
        }
        return sb.toString();
    }
}
