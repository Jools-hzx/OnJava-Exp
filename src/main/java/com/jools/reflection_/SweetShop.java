package com.jools.reflection_;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/11 20:22
 * @description: TODO
 */

class Cookie {
    static {
        System.out.println("Loading Cookie!!!");
    }
}

class Gum {
    static {
        System.out.println("Loading Gum!!!");
    }
}

class Candy {
    static {
        System.out.println("Loading Candy ~~~ ");
    }
}

public class SweetShop {

    public static void main(String[] args) {
        System.out.println("Inside main()");
        new Candy();    // 实例化，执行 Candy 的静态代码块
        System.out.println("After creating Candy");

        try {
            Class.forName("com.jools.reflection_.Gum");     // 反射调用
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("After class.forName('Gum')");
        new Cookie();   // 实例化，执行 Cookie 的静态代码块
        System.out.println("After creating Cookie");
    }
}
