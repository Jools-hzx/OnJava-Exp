package main.java.com.jools.runnable_;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/3/22 22:30
 * @description: TODO
 */

/*
 函数式接口: 只包含了一组接口 `java.util.function` 中的函数式接口
 这些接口是 lambda 表达式和方法引用的目标类型。
 每个接口都仅能够只包含一个抽象方法；被称为 ⌈函数式方法⌋
*/
@FunctionalInterface
interface Functional {
    String goodbye(String arg);
}

interface FunctionalNoAnn {
    String goodbye(String arg);
}

// 报错: Multiple non-overriding abstract methods found in interface main.java.com.jools.runnable_.NotFunctional
//@FunctionalInterface
interface NotFunctional {
    String goodbye(String arg);

    String hello(String arg);
}

public class FunctionalAnnotation {

    public String goodbye(String arg) {
        return "Goodbye, " + arg;
    }

    public static void main(String[] args) {
        FunctionalAnnotation fa = new FunctionalAnnotation();
        // [1] 相当于 FunctionalAnnotation 实现 Functional 之后使用
        //     FunctionalAnnotation 的 goodbye 方法逻辑实现原 Functional 接口中的方法
        Functional f = fa::goodbye;

        // [2] 相当于 FunctionalAnnotation 实现 Functional 之后使用
        //     FunctionalAnnotation 的 goodbye 方法逻辑实现原 Functional 接口中的方法
        FunctionalNoAnn fna = fa::goodbye;


        // [1] 相当于 FunctionalAnnotation 实现 Functional 之后重写 goodbye 方法
        Functional fl = a -> "Goodbye, " + a;
        FunctionalNoAnn fnal = a -> "Goodbye, " + a;
    }
}