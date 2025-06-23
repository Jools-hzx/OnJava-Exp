package com.jools.designpattern.decorator.printhelloworld;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/2/4 0:17
 * @description: TODO
 */
public abstract class Display {

    public abstract int getColumns();   // 获取列数

    public abstract int getRows();  // 获取行数

    public abstract String getRowText(int row); //获取第 row 行的字符串

    //输出显示
    public final void show() {
        for (int i = 0; i < getRows(); i++) {
            System.out.println(getRowText(i));
        }
    }
}
