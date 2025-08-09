package com.jools.designpattern.prototype;

import com.jools.designpattern.prototype.framework.Product;

/**
 * @author Jools He
 * @date 2025/7/26 16:14
 * @description: TODO
 */
public class UnderlinePen implements Product {

    private char ulchar;

    public UnderlinePen(char ulchar) {
        this.ulchar = ulchar;
    }

    // 输出 ~ 下划线打印
    @Override
    public void use(String s) {
        int len = s.getBytes().length;
        System.out.println("\"" + s + "\"");
        System.out.print(" ");
        for (int i = 0; i < len; i++) {
            System.out.print(ulchar);
        }
        System.out.println("");
    }

    @Override
    public Product createClone() {
        Product p = null;
        try {
            p = (Product) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return p;
    }
}
