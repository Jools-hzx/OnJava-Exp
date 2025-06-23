package com.jools.jdk.jdk8;

import org.junit.Test;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/2/7 14:17
 * @description: TODO
 */
public class InterfacesDemo implements InterfaceNew {
    @Override
    public void f1() {
        System.out.println(InterfacesDemo.class.getSimpleName() + " 实现 Interface f1()");
    }

    public static void main(String[] args) {

        InterfaceNew demo = new InterfacesDemo();
        demo.f1();

        // 接口的静态方法; 访问方式
//        InterfaceNew.m1();  报错 private 修饰不支持访问
        InterfaceNew.m2();

        // 访问接口的默认方法
        demo.def1();

        /*
         输出:
            InterfacesDemo 实现 Interface f1()
            Interface 提供的静态方法 m1
            Interface 提供的静态方法 m2
            Interface 提供的 default 方法 def1
        */
    }

    @Test
    public void test() {
        Inf1 interfaceImplDemo = new InterfaceImplDemo();
        interfaceImplDemo.testDef();    // 输出: Inf1 的 testDef() 方法
    }
}

class InterfaceImplDemo implements Inf1, Inf2 { // 不报错

}

interface Inf1 {

    default void testDef() {
        System.out.println("Inf1 的 testDef() 方法");
    }
}

interface Inf2 extends Inf1 {

    @Override
    default void testDef() {
        Inf1.super.testDef();
    }
}

interface InterfaceNew {

    private static void m1() {
        System.out.println("Interface 提供的静态方法 m1");
    }

    static void m2() {
        m1();       // 静态方法可访问静态 private 修饰的方法
        System.out.println("Interface 提供的静态方法 m2");
    }

    default void def1() {
        System.out.println("Interface 提供的 default 方法 def1");
    }

    // 必须要实现 f1
    void f1();
}
