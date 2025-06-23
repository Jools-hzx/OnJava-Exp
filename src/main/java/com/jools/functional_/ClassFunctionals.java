package main.java.com.jools.functional_;

import java.util.Comparator;
import java.util.function.*;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/3/22 23:28
 * @description: TODO
 */

class AAA {
}

class BBB {
}

class CCC {
}

public class ClassFunctionals {

    public static void main(String[] args) {

        // 提供者接口
        Supplier<AAA> s = ClassFunctionals::f1;
        System.out.println(s.get().getClass()); // 输出: class main.java.com.jools.functional_.AAA

        // Comparator 接口
        Comparator<AAA> c = ClassFunctionals::f2;
        System.out.println(c.compare(new AAA(), new AAA()));    // 输出: 1

        // Consumer 接口
        Consumer<AAA> consumer = ClassFunctionals::f3;
        consumer.accept(new AAA());

        // BiConsumer 接口
        BiConsumer<AAA, BBB> biCons = ClassFunctionals::f4;
        biCons.accept(new AAA(), new BBB());

        // Function 函数
        Function<AAA, CCC> f = ClassFunctionals::f5;
        f.apply(new AAA());

        // BiConsumer 接口
        BiConsumer<AAA, BBB> biCons2 = ClassFunctionals::f6;
        biCons2.accept(new AAA(), new BBB());

        //Predicate断言接口
        Function<AAA, Boolean> f7 = ClassFunctionals::f7;
        f7.apply(new AAA());

        // BiPredicate 断言接口
        BiConsumer<AAA, BBB> biCons3 = ClassFunctionals::f8;
        biCons3.accept(new AAA(), new BBB());

        // UnaryOperator 一元操作符
        UnaryOperator<AAA> f9 = ClassFunctionals::f9;
        f9.apply(new AAA());

        // BinaryOperator 二元操作符
        BinaryOperator<AAA> f10 = ClassFunctionals::f10;
        f10.apply(new AAA(), new AAA());
    }

    static AAA f1() {
        return new AAA();
    }

    static int f2(AAA a1, AAA a2) {
        return 1;
    }

    static void f3(AAA aaa) {
        System.out.println("f3()");
    }

    static void f4(AAA a, BBB b) {
        System.out.println("f4(AAA a, BBB b)");
    }

    static CCC f5(AAA aa) {
        return new CCC();
    }

    static CCC f6(AAA aa, BBB bbb) {
        return new CCC();
    }

    static boolean f7(AAA aaa) {
        return true;
    }

    static boolean f8(AAA aaa, BBB bbb) {
        return true;
    }

    static AAA f9(AAA aaa) {
        return new AAA();
    }

    static AAA f10(AAA aaa1, AAA aaa2) {
        return new AAA();
    }
}
