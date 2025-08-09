package com.jools.designpattern.prototype;

import com.jools.designpattern.prototype.framework.Manager;
import com.jools.designpattern.prototype.framework.Product;

/**
 * @author Jools He
 * @date 2025/7/26 16:17
 * @description: TODO
 */
public class PrototypeClient {

    public static void main(String[] args) {
        // 初始化，注册各个 Product
        Manager manager = new Manager();
        UnderlinePen upen = new UnderlinePen('~');
        MessageBox mbox = new MessageBox('*');
        MessageBox sbox = new MessageBox('-');
        // 注册
        manager.register("underline", upen);
        manager.register("warning box", mbox);
        manager.register("slash box", sbox);

        // 查看注册结果
        /*
         输出结果:
            Register result:
            key: underline -> com.jools.designpattern.prototype.UnderlinePen@685f4c2e
            key: slash box -> com.jools.designpattern.prototype.MessageBox@7daf6ecc
            key: warning box -> com.jools.designpattern.prototype.MessageBox@2e5d6d97
        */
        System.out.println("Register result:");
        manager.getShowCases().
                forEach((k, v) ->
                                System.out.println("key: " + k + " -> " + v));

        // 生成
        Product product_1 = manager.create("underline");
        product_1.use("Hello!! Jools He!!!!");

        Product product_2 = manager.create("warning box");
        product_2.use("The second Warning box!!");

        Product product_3 = manager.create("slash box");
        product_3.use("The third slash box!!!");

        /*
         输出结果:
            "Hello!! Jools He!!!!"
             ~~~~~~~~~~~~~~~~~~~~
            ****************************
            * The second Warning box!! *
            ****************************
            --------------------------
            - The third slash box!!! -
            --------------------------
        */
    }
}
