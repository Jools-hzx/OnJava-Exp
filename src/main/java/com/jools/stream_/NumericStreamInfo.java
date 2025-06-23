package main.java.com.jools.stream_;

import static main.java.com.jools.stream_.RandInts.rands;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/3 1:37
 * @description: TODO
 */
public class NumericStreamInfo {

    public static void main(String[] args) {
        System.out.println(rands().average().getAsDouble());
        System.out.println(rands().max().getAsInt());
        System.out.println(rands().min().getAsInt());
        System.out.println(rands().sum());
        System.out.println(rands().summaryStatistics());
        /*
        输出:
        507.94
        998
        8
        50794
        IntSummaryStatistics{count=100, sum=50794, min=8, average=507.940000, max=998}
        */
    }
}
