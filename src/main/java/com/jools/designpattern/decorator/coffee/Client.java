package com.jools.designpattern.decorator.coffee;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/2/4 13:54
 * @description: TODO
 */
public class Client {

    public static void main(String[] args) {

        DarkRoast beverage = new DarkRoast();
        System.out.println(beverage.cost());

        Beverage b2 = new Milk(beverage);
        System.out.println(b2.cost());

        Beverage b3 = new Mocha(new Milk(beverage));
        System.out.println(b3.cost());

        /*
         输出:
            1.0
            2.0
            3.0
        */
    }
}
