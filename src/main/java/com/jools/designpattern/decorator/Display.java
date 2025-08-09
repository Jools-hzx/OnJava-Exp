package com.jools.designpattern.decorator;

/**
 * @author Jools He
 * @description: 可以显示多行字符串的抽象类
 */
public abstract class Display {

    public abstract int getColumns();   // 获取横向的字符数目

    public abstract int getRows();      // 获取纵向行数

    public abstract String getRowText(int row); // 获取第 row 行的字符串

    public final void show() {
        for (int i = 0; i < getRows(); i++) {
            System.out.println(getRowText(i));
        }
    }
}
