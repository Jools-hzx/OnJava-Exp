package com.jools.designpattern.bridge;

/**
 * @author Jools He
 * @date 2025/7/27 12:48
 * @description: TODO
 */
public class TriStrDisplayImpl extends TriDisplayImpl{

    private String starter;
    private String ender;
    private String content;

    public TriStrDisplayImpl(String starter, String content, String ender) {
        this.starter = starter;
        this.content = content;
        this.ender = ender;
    }

    @Override
    public void printTriLine(int times) {
        int cnt = 1;
        while (cnt <= times) {
            System.out.print(starter);
            for (int i = 0; i < cnt; i++) {
                System.out.print(content);
            }
            System.out.println(ender);
            cnt++;
        }
    }
}
