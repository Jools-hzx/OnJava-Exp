package com.jools.designpattern.adapter;

/**
 * @author Jools He
 * @date 2025/7/13 22:56
 * @description: TODO
 */
public class PrintBanner extends Print {

    private Banner banner;

    public PrintBanner(Banner banner) {
        this.banner = banner;
    }

    @Override
    public void printWeak() {
        banner.showWithParen();
    }

    @Override
    public void printStrong() {
        banner.showWithAster();
    }
}
