package main.java.com.jools.functional_;

import cn.hutool.core.lang.func.Func;

import java.util.PriorityQueue;
import java.util.function.Function;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/3/31 20:12
 * @description: TODO
 */
public class ProduceFunction {

    // 能够接收函数作为参数或者把函数当作返回值函数
    static FuncSS produce() {
        return s -> s.toLowerCase();
    }

    public static void main(String[] args) {
        FuncSS fss = produce();
        System.out.println(fss.apply("HELLO")); // 输出: hello
    }
}

interface FuncSS extends Function<String, String> {
}
