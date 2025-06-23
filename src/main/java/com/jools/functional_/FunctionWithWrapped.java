package main.java.com.jools.functional_;

import java.util.function.Function;
import java.util.function.IntToDoubleFunction;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/3/31 20:05
 * @description: TODO
 */
public class FunctionWithWrapped {

    public static void main(String[] args) {

        Function<Integer, Double> fid = i -> (double) i;
        IntToDoubleFunction fid2 = i -> i;

        Double iToD = fid.apply(1000);
        System.out.println(iToD);   // 输出: 1000.0
        double d = fid2.applyAsDouble(100);
        System.out.println(d);  // 输出 100.0
    }
}
