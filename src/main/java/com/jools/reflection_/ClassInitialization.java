package com.jools.reflection_;

import java.util.Random;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/11 21:10
 * @description: TODO
 */

class Initable {
    static final int STATIC_FINAL = 47;
    static final int STATIC_FINAL2 = ClassInitialization.rand.nextInt(1000);

    static {
        System.out.println("Initializing Initable");
    }
}

class Initable2 {
    static int STATIC_NON_FINAL = 147;

    static {
        System.out.println("Initializing Initable2");
    }
}

class Initable3 {
    static int STATIC_NON_FINAL = 74;

    static {
        System.out.println("Initializing1 Initable3");
    }
}

public class ClassInitialization {

    public static Random rand = new Random(47);

    public static void main(String[] args) throws ClassNotFoundException {
        Class<Initable> aClass = Initable.class;
        System.out.println("After creating Initable ref");
        // 不会触发初始化; 因为是访问常量静态字段
        System.out.println(Initable.STATIC_FINAL);
        // 触发初始化; 因为访问的时非常量静态字段; 借助 Random 类
        System.out.println(Initable.STATIC_FINAL2); // 输出随机数字
        // 触发初始化; 因为访问了 Initable2 的非常量字段; 未用 final 字段修饰
        System.out.println(Initable2.STATIC_NON_FINAL); //
        Class<?> aClsInitable3 = Class.forName("com.jools.reflection_.Initable3");
        System.out.println("After creating Initable3 ref");
        System.out.println(Initable3.STATIC_NON_FINAL);

        /*
         输出:
            After creating Initable ref
            47
            Initializing Initable
            258
            Initializing Initable2
            147
            Initializing1 Initable3
            After creating Initable3 ref
            74
        */
    }
}
