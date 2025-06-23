package com.jools.reflection;

import java.util.Random;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/1/20 11:56
 * @description: TODO
 */
public class LazyInitializing {

    public static Random rand = new Random(47);

    public static void main(String[] args) throws ClassNotFoundException {

        Class<Initable> initableClass = Initable.class;
        System.out.println("After creating Initable ref");
        //不会触发初始化
        System.out.println(Initable.STATIC_FINAL);
        //触发初始化
        System.out.println(Initable.STATIC_FINAL2);
        //触发初始化
        System.out.println(Initable2.staticNonFinal);
        Class<?> cls = Class.forName("com.jools.reflection.Initable3");
        System.out.println("After creating Initable3 ref");
        System.out.println(Initable3.staticNonFinal);

        /*
         输出:
            After creating Initable ref
            47
            Initializing Initable
            4258
            Initializing Initable2
            55
            Initializing Initable3
            After creating Initable3 ref
            75
         */
    }
}

class Initable {
    static final int STATIC_FINAL = 47;

    static final int STATIC_FINAL2 = LazyInitializing.rand.nextInt(5000);

    static {
        System.out.println("Initializing Initable");
    }
}

class Initable2 {

    static int staticNonFinal = 55;

    static {
        System.out.println("Initializing Initable2");
    }
}

class Initable3 {
    static int staticNonFinal = 75;

    static {
        System.out.println("Initializing Initable3");
    }
}
