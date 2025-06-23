package com.jools.jmh.quickstart;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/2/12 10:59
 * @description: TODO
 */
public class JmhMain {

//    @Benchmark
//    public void init() {
//        //
//    }

//    @Benchmark
//    @BenchmarkMode(Mode.AverageTime)
//    public void testAvg() {
//        //TODO: Do something
//    }

    //BenchMark Method based on State
//    @Fork(value = 1, warmups = 1)
//    @Benchmark
//    @BenchmarkMode(Mode.AverageTime)
//    public void benchMurmur3_128(HashExecutionPlan plan) {
//        for (int i = 0; i < plan.iterations; i++) {
//            plan.murmur3.putString(plan.password, Charset.defaultCharset());
//        }
//        plan.murmur3.hash();
//    }
//
//    @Benchmark
//    @OutputTimeUnit(TimeUnit.NANOSECONDS)
//    @BenchmarkMode(Mode.AverageTime)
//    public void testAvgTimeUnit() {
//        //TODO: Do something
//    }

//    @Benchmark
//    @Fork(value = 1, warmups = 2)
//    @BenchmarkMode(Mode.AverageTime)
//    public void testCustomizeFork() {
//        //TODO: Do something
//    }

    @Benchmark
    @Fork(value = 1, warmups = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public void doNothing() {

    }

    @Benchmark
    @Fork(value = 1, warmups = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public void objCreation() {
        new Object();
    }

    @Benchmark
    @Fork(value = 1, warmups = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public Object returnObject() {
        return new Object();
    }

    @Benchmark
    @Fork(value = 1, warmups = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public void returnABlackHole(Blackhole blackhole) {
        blackhole.consume(new Object());
    }



    public static void main(String[] args) throws IOException {
//        org.openjdk.jmh.Main.main(args);
    }
}
