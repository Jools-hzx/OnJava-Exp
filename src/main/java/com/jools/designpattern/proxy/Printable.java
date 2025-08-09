package com.jools.designpattern.proxy;

/**
 * @author Jools He
 */
public interface Printable {

    // 设置名字
    void setPrinterName(String name);

    // 获取名字
    String getPrinterName();

    // 显示打印输出名字
    void print(String str);
}
