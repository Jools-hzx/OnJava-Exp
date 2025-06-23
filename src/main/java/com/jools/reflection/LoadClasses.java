package com.jools.reflection;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/1/20 11:26
 * @description: TODO
 */
public class LoadClasses {

    public static void main(String[] args) {
        System.out.println("Inside main");
        new Candy();
        System.out.println("After creating Candy");
        try {
            Class.forName("com.jools.reflection.Gum");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("After Class.forName(Gum)");
        new Cookie();
        System.out.println("After creating Cookie()");

        /*
         输出:
            Inside main
            Loading Candy!!!
            After creating Candy
            Loading Gum!!!
            After Class.forName(Gum)
            Loading Cookie!!!
            After creating Cookie()
         */
    }
}


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
        System.out.println("Loading Candy!!!");
    }
}
