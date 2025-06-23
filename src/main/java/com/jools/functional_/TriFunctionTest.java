package main.java.com.jools.functional_;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/3/22 23:42
 * @description: TODO
 */


@FunctionalInterface
interface TriFunction<T, U, V, R> {
    R apply(T t, U u, V v);
}

public class TriFunctionTest {

    static int f(int i, long l, double d) {
        System.out.println("Input:  i=" + i + ", l=" + l + ", d=" + d);
        return 99;
    }

    public static void main(String[] args) {
        TriFunction<Integer, Long, Double, Integer> tf;
        // 函数引用指向的是一个函数式接口；
        // 函数引用的参数列表与返回值类型必须与函数式接口的抽象方法的参数列表和返回值类型保持一致。
        // 底层一个匿名内部类实现函数式接口并且使用函数引用指向的方法逻辑实现函数式接口的抽象方法
        tf = TriFunctionTest::f;

        System.out.println(tf.apply(1, 2L, 3.0));

        // 输出
        // Input:  i=1, l=2, d=3.0
    }
}
