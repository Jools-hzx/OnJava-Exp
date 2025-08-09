package com.jools.designpattern.factory;

import com.jools.designpattern.factory.framework.Factory;
import com.jools.designpattern.factory.framework.Product;
import com.jools.designpattern.factory.idcard.IDCardFactory;

/**
 * @author Jools He
 * @date 2025/7/25 22:07
 * @description: TODO
 */
public class FactoryMethodClient {

    public static void main(String[] args) {
        Factory factory = new IDCardFactory();
        Product card1 = factory.create("Jools");
        Product card2 = factory.create("Wakoo");
        Product card3 = factory.create("Franck Jools");
        card1.use();
        card2.use();
        card3.use();

        System.out.println("注册的所有用户: ");
        ((IDCardFactory) factory).
                getOwners().
                forEach(System.out::println);
        System.out.println("注册的所有用户编号: ");
        ((IDCardFactory) factory).
                getNo().
                forEach(System.out::println);

        /*
         输出:
             制作 Jools 的 ID 卡
             制作 Wakoo 的 ID 卡
             制作 Franck Jools 的 ID 卡
            使用 Jools 的 ID 卡
            使用 Wakoo 的 ID 卡
            使用 Franck Jools 的 ID 卡
        */
    }
}
