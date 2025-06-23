package main.java.com.jools.functional_;

import java.util.function.IntSupplier;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/3/31 20:35
 * @description: TODO
 */
public class Closure01 {
    int i;

    IntSupplier makeFun(int x) {
        return () -> x + i++;
    }

    public static void main(String[] args) {
        Closure01 c = new Closure01();
        int ans = c.makeFun(111).getAsInt();
        System.out.println("makeFun() result: " + ans + "\t i=" + c.i);
        // 输出结果: makeFun() result: 111     i=1

        IntSupplier f1 = c.makeFun(0);
        IntSupplier f2 = c.makeFun(0);
        IntSupplier f3 = c.makeFun(0);
        System.out.println(f1.getAsInt());  // 1
        System.out.println(f2.getAsInt());  // 2
        System.out.println(f3.getAsInt());  // 3
    }
}
