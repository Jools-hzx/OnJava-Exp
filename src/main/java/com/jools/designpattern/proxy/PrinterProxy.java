package com.jools.designpattern.proxy;

/**
 * @author Jools He
 * @date 2025/7/29 23:25
 * @desc: 扮演代理人角色的类，实现了 Printable
 */
public class PrinterProxy implements Printable {

    // 名字 - 打印机的名字
    private String name;

    // 本人
    private Printer real;

    public PrinterProxy(String name) {
        this.name = name;
    }

    @Override
    public void setPrinterName(String name) {
        if (real != null) {
            real.setPrinterName(name);
        }
        this.name = name;
    }

    @Override
    public String getPrinterName() {
        return name;
    }

    @Override
    public void print(String str) {
        try {
            realize();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        real.print(str);
    }

    // 生成本人
    private synchronized void realize() throws InterruptedException {
        if (real == null) {
            real = new Printer(name);
        }
    }
}
