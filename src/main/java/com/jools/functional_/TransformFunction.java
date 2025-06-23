package main.java.com.jools.functional_;

import java.util.function.Function;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/3/31 20:23
 * @description: TODO
 */
public class TransformFunction {

    // 生成一个与传入函数签名相同更多函数
    static Function<I, O> transform(Function<I, O> in) {
        // andThen 是默认方法，专门为操作函数而设计
        // andThen() 会在 in 函数调用之后调用
        return in.andThen(
                o -> {
                    System.out.println("Inside Function:" + o);
                    return o;
                }
        );
    }

    public static void main(String[] args) {
        Function<I, O> f2 = transform(i -> {
            System.out.println("Inside tramsform:" + i);
            return new O();
        });
        O o = f2.apply(new I());
        /*
         输出:
         1. Inside tramform: I
         2. Inside Function: O
        */
    }
}

class I {
    @Override
    public String toString() {
        return "I";
    }
}

class O {
    @Override
    public String toString() {
        return "O";
    }
}
