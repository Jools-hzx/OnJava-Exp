package com.jools.designpattern.proxy;

/**
 * @author Jools He
 * @date 2025/7/29 23:18
 * @description: TODO
 */
public class Printer implements Printable {

    private String name;

    public Printer(String name) throws InterruptedException {
        this.name = name;
        heavyJob("Printer 的实例生产中....");
    }

    @Override
    public void setPrinterName(String name) {
        this.name = name;
    }

    @Override
    public String getPrinterName() {
        return name;
    }

    @Override
    public void print(String str) {
        System.out.println("==== " + name + " ====");
        System.out.println(str);
    }

    // 重量级别的初始化实例的方法
    private void heavyJob(String msg) throws InterruptedException {
        System.out.println(msg);
        for (int i = 0; i < 5; i++) {
            Thread.sleep(1000);
        }
        System.out.println("结束。");
    }
}
