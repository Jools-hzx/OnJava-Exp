package com.jools.designpattern.bridge;

/**
 * @author Jools He
 * @description: DisplayImpl 的实现类, 显示字符串,作为 DisplayImpl 的子类
 */
public class StringDisplayImpl extends DisplayImpl{

    // 待显示的字符串
    private String string;

    // 以字节单位计算出的字符串长度
    private int width;

    public StringDisplayImpl(String string) {
        this.string = string;
        this.width = string.getBytes().length;
    }

    @Override
    public void rawOpen() {
        printLine();
    }

    @Override
    public void rawPrint() {
        System.out.println("|" + string + "|");
    }

    @Override
    public void rawClose() {
        printLine();
    }

    private void printLine() {
        System.out.print("+");
        for (int i = 0; i < width; i++) {
            System.out.print("-");
        }
        System.out.println("+");
    }
}
