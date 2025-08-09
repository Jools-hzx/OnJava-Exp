package com.jools.designpattern.factory.idcard;

import com.jools.designpattern.factory.framework.Product;

/**
 * @author Jools He
 * @date 2025/7/25 22:00
 * @description: TODO
 */
public class IDCard extends Product {

    private String owner;
    private String no;

    IDCard(String owner) {
        System.out.println(" 制作 " + owner + " 的 ID 卡");
        this.owner = owner;
    }

    IDCard(String owner, String no) {
        System.out.println(" 制作 " + owner + " 的 ID 卡 —— 编号为:" + no);
        this.owner = owner;
        this.no = no;
    }

    @Override
    public void use() {
        System.out.println("使用 " + owner + " 的 ID 卡 —— 卡号为:" + no);
    }

    public String getOwner() {
        return owner;
    }

    public String getNo() {
        return no;
    }
}
