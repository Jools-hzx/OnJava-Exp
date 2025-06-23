package main.java.com.jools.functional_;

import java.util.function.IntSupplier;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/3/31 20:46
 * @description: TODO
 */
public class Closure2 {

    // 返回 IntSupplier 是在 i 和 x 之上构建的闭包;
    IntSupplier makeFun(int x) {
        // 支持标记为最终变量
        /*final*/
        int i = 0;
//        return () -> x++ + i++; // 报错:Variable used in lambda expression should be final or effectively fina
        return () -> x + i;
    }

}
