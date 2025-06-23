package main.java.com.jools.functional_;

import java.util.function.BiConsumer;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/3/22 23:19
 * @description: TODO
 */

class Inl {
}

class In2 {
}

public class MethodConversion {

    static void accept(Inl il, In2 i2) {
        System.out.println("accept()");
    }

    static void someOtherName(Inl il, In2 i2) {
        System.out.println("someOtherName()");
    }

    public static void main(String[] args) {
        BiConsumer<Inl, In2> bic;

        // 方法引用
        bic = MethodConversion::accept; //[1] 匿名内部类实现 BiConsumer 接口重写 accept 方法
        bic.accept(new Inl(), new In2());

        bic = MethodConversion::someOtherName;  //[2] 匿名内部类实现 BiConsumer 接口重写 accept 方法
        bic.accept(new Inl(),new In2());
    }
}
