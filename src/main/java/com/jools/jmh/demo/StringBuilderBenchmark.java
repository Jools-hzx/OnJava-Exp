package com.jools.jmh.demo;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/2/12 14:44
 * @description: TODO
 */

@BenchmarkMode({Mode.AverageTime, Mode.Throughput})
@Fork(value = 3, warmups = 5)
@Warmup(time = 1000, timeUnit = TimeUnit.MILLISECONDS)
@Threads(20)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
// 基本测试参数:  iterations 进行测试的伦茨  time 每轮进行的时长  timeUnit 时长单位
@Measurement(iterations = 10, time = 10, timeUnit = TimeUnit.MILLISECONDS)
public class StringBuilderBenchmark {

    @Benchmark
    public void testStringConcat() {
        String base = "";
        for (int i = 0; i < 100; i++) {
            base += i;
        }
    }

    @Benchmark
    public void testStringBuilderConcat() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            sb.append(i);
        }
    }

    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder().include(StringBuilderBenchmark.class.getSimpleName())
                .output("D://StringBuilderBenchmark.log")
                .build();
        new Runner(options).run();
    }

}
