package com.jools.jmh.quickstart;

import org.openjdk.jmh.annotations.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/2/12 14:16
 * @description: TODO
 */
public class ConstantFoldDemo {


    @State(Scope.Benchmark)
    public static class Log {
        public int x = 8;
    }

    @Benchmark
    @Fork(value = 1, warmups = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public double log(Log input) {
        return Math.log(input.x);
    }

    public static void main(String[] args) throws IOException {
        org.openjdk.jmh.Main.main(args);
    }
}
