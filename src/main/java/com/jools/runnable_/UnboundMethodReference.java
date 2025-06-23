package main.java.com.jools.runnable_;

import org.junit.Test;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/3/22 19:31
 * @description: TODO
 */
public class UnboundMethodReference {

    public static void main(String[] args) {

//         MakeString ms = X::f;
        TransformX sp = X::f;   // 对方法的引用与其关联接口的签名是相同的
        X x = new X();

        // 在未绑定引用的情况下，⌈函数式方法⌋ 的签名与方法引用的签名不再是完全匹配
        System.out.println(sp.transform(x));
        System.out.println(x.f());
    }

    @Test
    public void testBind() {
        // 如果有更多参数，只要遵循第一个参数取的是 this 这种模式
        TwoArgs twoArgs = This::two;
        ThreeArgs threeArgs = This::three;
        FourArgs fourArgs = This::four;
        This athis = new This();
        twoArgs.call2(athis, 1, 1.0);
        threeArgs.call3(athis, 1, 1.0, "1");
        fourArgs.call4(athis, 1, 1.0, "1", '1');
    }
}

interface TwoArgs {
    void call2(This athis, int i, double d);
}

interface ThreeArgs {
    void call3(This athis, int i, double d, String s);
}

interface FourArgs {
    void call4(This athis, int i, double d, String s, char c);
}

class This {
    void two(int i, double d) {
    }

    void three(int i, double d, String s) {
    }

    void four(int i, double d, String s, char c) {
    }
}

class X {
    String f() {
        return "X::f";
    }
}

interface MakeString {
    String make();
}

interface TransformX {
    String transform(X x);
}