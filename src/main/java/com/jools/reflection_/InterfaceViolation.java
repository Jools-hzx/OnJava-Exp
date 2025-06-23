package com.jools.reflection_;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/13 23:31
 * @description: TODO
 */
public class InterfaceViolation {

    public static void main(String[] args) {
        A a = new B();
        a.f();      // 调用接口抽象方法 - 通过
//        a.g();  // 报错
        System.out.println(a.getClass().getName());
        if (a instanceof B) {
            B b = ((B) a);    // 通过强制转型为 B, 可以调用不在 A 中的方法
            b.g();
        }
    }
}

class B implements A {

    @Override
    public void f() {

    }

    // B 类实普通例方法
    public void g() {
    }
}


