package com.jools.designpattern.prototype;

import com.jools.designpattern.prototype.framework.Product;

/**
 * @author Jools He
 * @date 2025/7/26 15:59
 * @description: TODO
 */
public class MessageBox implements Product {

    private char decochar;

    public MessageBox(char decochar) {
        this.decochar = decochar;
    }

    @Override
    public void use(String s) {
        int len = s.getBytes().length;  // 根据输入的字符用 * 包围起来
        for (int i = 0; i < len + 4; i++) {
            System.out.print(decochar);
        }
        System.out.println();
        System.out.println(decochar + " " + s + " " + decochar);
        for (int i = 0; i < len + 4; i++) {
            System.out.print(decochar);
        }
        System.out.println();
    }

    // 复制自己 [基于 Product 实现了 Cloneable 接口]。内部所调用的 clone 方法是 Java 语言中定义的方法; 用于复制自己
    @Override
    public Product createClone() {
        Product p = null;
        try {
            p = (Product) clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return p;
    }
}
