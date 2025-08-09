package com.jools.designpattern.proxy;

/**
 * @author Jools He
 * @date 2025/7/29 23:33
 * @description: TODO
 */
public class Main {
    public static void main(String[] args) {
        Printable p = new PrinterProxy("Jools He");
        System.out.println("当前打印机的名字是:" + p.getPrinterName());
        p.setPrinterName("Franck Jools");
        System.out.println("现在的名字是:" + p.getPrinterName());
        p.print("Hello, World!!!");

        /*
         执行结果:
            当前打印机的名字是:Jools He
            现在的名字是:Franck Jools
            Printer 的实例生产中....
            结束。
            ==== Franck Jools ====
            Hello, World!!!
        */
    }
}
