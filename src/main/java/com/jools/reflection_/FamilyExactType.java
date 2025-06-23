package com.jools.reflection_;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/12 18:20
 * @description: TODO
 */

class Base {
}

class Derived extends Base {
}

public class FamilyExactType {

    static void test(Object x) {
        // 输出实例类型
        System.out.println("Testing x of test: " + x.getClass());

        // instanceof
        System.out.println("x instanceof Base: " + (x instanceof Base));
        System.out.println("x instanceof Derived: " + (x instanceof Derived));

        // isInstance() 方式
        System.out.println("Base.isInstance(x):  " + Base.class.isInstance(x));
        System.out.println("Derived.isInstance(x): " + Derived.class.isInstance(x));

        // == 方式
        System.out.println("x.getClass() == Base.class:  --> " + (x.getClass() == Base.class));

        // equals 方法
        System.out.println("x.getClass().equals(Base.class):  --> " + (x.getClass().equals(Base.class)));
        System.out.println("x.getClass().equals(Derived.class):  --> " + (x.getClass().equals(Derived.class)));
    }

    public static void main(String[] args) {
        test(new Base());
        /*
         输出结果 - 组一:
            Testing x of test: class com.jools.reflection_.Base
            x instanceof Base: true
            x instanceof Derived: false
            Base.isInstance(x):  true
            Derived.isInstance(x): false
            x.getClass() == Base.class:  --> true
            x.getClass().equals(Base.class):  --> true
            x.getClass().equals(Derived.class):  --> false
        */
        System.out.println("----------------");
        test(new Derived());
        /*
         输出结果 - 组二:
            Testing x of test: class com.jools.reflection_.Derived
            x instanceof Base: true
            x instanceof Derived: true
            Base.isInstance(x):  true
            Derived.isInstance(x): true
            x.getClass() == Base.class:  --> false
            x.getClass().equals(Base.class):  --> false
            x.getClass().equals(Derived.class):  --> true
        */
    }
}
