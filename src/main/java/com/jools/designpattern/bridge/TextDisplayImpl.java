package com.jools.designpattern.bridge;

/**
 * @author Jools He
 * @date 2025/7/27 12:40
 * @description: TODO
 */
public class TextDisplayImpl extends DisplayImpl{

    // 待显示的文本
    private String txt;

    // 以字符单位计算出字符串长度
    private int width;

    public TextDisplayImpl(String txt) {
        this.txt = txt;
        this.width = txt.length();
    }

    @Override
    public void rawOpen() {
        printLine();
    }

    @Override
    public void rawPrint() {
        System.out.println("|" + txt + "|");
    }

    @Override
    public void rawClose() {
        printLine();
    }

    private void printLine() {
        System.out.print("This is a txt");
        for (int i = 0; i < width; i++) {
            System.out.print("-");
        }
        System.out.println("This is a txt");
    }
}
