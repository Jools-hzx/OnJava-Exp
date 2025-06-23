package com.jools.jdk.jdk8.functionalInfs;

import org.junit.Assert;
import org.junit.Test;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Threads;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.lang.reflect.Array;
import java.security.PublicKey;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/2/7 17:09
 * @description: TODO
 */
public class LambdaExpressionDemo {

    @Test
    public void testParallelStream() {
        List<Integer> nums = Arrays.asList(1, 2, 3, 5);
        nums.parallelStream().forEach(n -> System.out.println(Thread.currentThread().getName() + " ——> " + n));

        /*
         执行结果:
            ForkJoinPool.commonPool-worker-3 ——> 5
            ForkJoinPool.commonPool-worker-1 ——> 2
            main ——> 3
            ForkJoinPool.commonPool-worker-2 ——> 1
         */
    }

    @Test
    public void delayExecution() {

        List<String> strs = Arrays.asList("1", "2", "3", "4");
        Stream<String> stream = strs.stream().filter(
                new Predicate<String>() {
                    @Override
                    public boolean test(String s) {
                        System.out.println(this.getClass().getSimpleName() + " test() 方法执行....");
                        return true;
                    }
                }
        );

        System.out.println("count() 执行");
        long count = stream.count();

        /*
         执行结果:
         count() 执行
         test() 方法执行....
         test() 方法执行....
         test() 方法执行....
         test() 方法执行....
         */
    }

    @Test
    public void testCommonMethodsGroup() {

        // 收集集合
        List<String> strs = Arrays.asList("abc", "def", "ghi", "hkl");

        // 过滤 stream 内符合条件的元素并收集
        List<String> filterCollection = strs.stream().filter(s -> "abc".equals(s)).collect(Collectors.toList());
        System.out.println("符合条件的元素个数:" + filterCollection.size()); // 输出: 1
        Assert.assertEquals(1, filterCollection.size());

        // 添加分割负号
        String addComma = strs.stream().filter((s) -> !s.isEmpty()).collect(Collectors.joining(","));
        Assert.assertEquals("abc,def,ghi,hkl", addComma);   // pass

        // 进行数组统计
        List<Integer> nums = Arrays.asList(1, 2, 5, 4);
        IntSummaryStatistics statistics = nums.stream().mapToInt((s) -> s).summaryStatistics();
        System.out.println("最大的数为:" + statistics.getMax());     // 输出: 5
        System.out.println("最小的数为:" + statistics.getMin());     // 输出: 1
        System.out.println("平均数为:" + statistics.getAverage());  // 输出: 3.0
        System.out.println("所有数之和" + statistics.getSum());      // 输出: 12

        // 合并两个流 a b; 返回结果 a b
        Stream<String> aStream = Stream.of("a", "b", "c");
        Stream<String> bStream = Stream.of("d", "e", "f");
        Stream<String> concatStream = Stream.concat(aStream, bStream);
        concatStream.forEach((s) -> System.out.print(s + ",")); // 输出: a,b,c,d,e,f,
        System.out.println();

        // Stream 只能操作一次，否则会报错
        Stream<Integer> intStream = Stream.of(1, 2);
        try {
            // 首次使用
            intStream.limit(2);
            // 第二次使用
            intStream.forEach(System.out::println);
        } catch (Exception e) {
            // 输出错误信息: java.lang.IllegalStateException: stream has already been operated upon or closed
            System.out.println(e.getMessage());
        }

        // 重新创建之后
        intStream = Stream.of(1, 2);
        intStream.forEach((s) -> System.out.print(s + ","));    // 输出: 1,2,
    }

    @Test
    public void testStream() {

        // 获取 0 ~ N 个 Stream 内元素
        Stream<String> limitedStream = digitStr.stream().limit(3);
        System.out.println("流内元素数目:" + limitedStream.count());   // 3

        // map 对元素映射操作返回新流
        Stream<String> mapperStream = digitStr.stream().map((s) -> s + "mapped");
        mapperStream.forEach((s) -> System.out.print(s + "\t"));
        System.out.println();
        // 输出: 1mapped	2mapped	3mapped	4mapped	5mapped	6mapped	7mapped	8mapped	9mapped
        // 10mapped 2mapped 3mapped	4mapped	5mapped

        // sorted 对于流内元素进行排序和打印 测试: 按照递减顺序排序
        Stream<String> sortedStream = digitStr.stream().sorted((s1, s2) -> {
            return Integer.valueOf(s2) - Integer.valueOf(s1);
        });

        sortedStream.forEach((s) -> System.out.print(s + "\t"));
        // 输出: 10	9	8	7	6	5	5	4	4	3	3	2	2	1

        // skip() 丢弃第一个 n 元素后，返回由该流的 n元素组成的流
        System.out.println();
        System.out.println("丢弃之前流内元素总数:" + digitStr.stream().count()); // 输出: 14
        Stream<String> skipped = digitStr.stream().skip(3);
        System.out.println("丢弃之后流内元素总数:" + skipped.count());    // 输出: 11
        digitStr.stream().skip(3).forEach((s) -> System.out.print(s + "\t"));
        //输出: 4	5	6	7	8	9	10	2	3	4	5
    }

    @Test
    public void runnableImpl() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Test the runnable impl");
            }
        }).start();


        new Thread(() -> System.out.println("Using lamdba test the runnable impl")).start();

        /*
         输出:
         Test the runnable impl
         Using lamdba test the runnable impl
         */
    }

    @Test
    public void testListener() {
        JButton button = new JButton();
        button.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                e.getItem();
            }
        });

        // lambda
        button.addItemListener(e -> e.getItem());
    }

    @Test
    public void testComparator() {
        List<Integer> ints = Arrays.asList(1, 2, 3, 4, 5);


    }


    @Test
    public void testInterfaces() {
        LambdaClass.forEg();    //Lambda interface demo
    }


    /**
     * 测试集合的遍历方式
     */
    @Test
    public void testCollectionIter() {

        // 创建一个包含字符串的列表
        List<String> strings = Arrays.asList("1", "2", "3", "4", "5", "6");

        // 构建流方式 01 - 串行流
        Stream<String> stream = strings.stream();

        // 构建流方式 02 - 返回 T 的liu
        Stream<List<String>> listStrStream = Stream.of(strings);

        // 构建流的方式 03 - 返回并行流
        Stream<String> parallelStream = strings.parallelStream();

        // 构建流的方式 04 - 返回其元素是指定值的顺序流
        Stream<String> strStream = Stream.of("11", "22,", "33", "44", "55");


        // 测试常用方法组 02: 过滤、匹配
        //过滤
        Stream<String> filterStream = strings.stream().filter((s) -> Integer.valueOf(s) > 3);

        Predicate<String> isGreaterThree = new Predicate<>() {
            @Override
            public boolean test(String s) {
                return Integer.valueOf(s) > 3;
            }
        };

        // 验证此流内的所有元素是否大于提供的体哦阿健
        boolean match = filterStream.allMatch(isGreaterThree);
        System.out.println(match);
    }

    @Test
    public void testCommonMethodsGroup02() {
        List<String> digitStr = Arrays.asList("1", "2", "3", "4", "5",
                "6", "7", "8", "9", "10", "2", "3", "4", "5");

        // 遍历所有输出
        digitStr.forEach((s) -> System.out.print(s + "\t"));

        // 返回此流中的元素总数
        long count = digitStr.stream().count();
        System.out.println("\n此流内的元素总数:" + count);

        // 返回由该流内不同元组组成的流 根据 Object.equals()
        Stream<String> distincted = digitStr.stream().distinct();
        System.out.println("去除重复之后");
        distincted.forEach((s) -> System.out.print(s + "\t"));

        /*
         输出:
            1	2	3	4	5	6	7	8	9	10	2	3	4	5
            此流内的元素总数:14
            去除重复之后
            1	2	3	4	5	6	7	8	9	10
        */
    }

    private static List<String> digitStr = Arrays.asList("1", "2", "3", "4", "5",
            "6", "7", "8", "9", "10", "2", "3", "4", "5");

    @Test
    public void testCommonMethodsGroup03() {
        // 获取 0 ~ N 个 Stream 内元素
        Stream<String> limitedStream = digitStr.stream().limit(3);
        System.out.println("流内元素数目:" + limitedStream.count());   // 3

        // map 对元素映射操作返回新流
        Stream<String> mapperStream = digitStr.stream().map((s) -> s + "mapped");
        mapperStream.forEach((s) -> System.out.print(s + "\t"));
        System.out.println();
        // 输出: 1mapped	2mapped	3mapped	4mapped	5mapped	6mapped	7mapped	8mapped	9mapped
        // 10mapped 2mapped 3mapped	4mapped	5mapped

        // sorted 对于流内元素进行排序和打印 测试: 按照递减顺序排序
        Stream<String> sortedStream = digitStr.stream().sorted((s1, s2) -> {
            return Integer.valueOf(s2) - Integer.valueOf(s1);
        });

        sortedStream.forEach((s) -> System.out.print(s + "\t"));
        // 输出: 10	9	8	7	6	5	5	4	4	3	3	2	2	1

        // skip() 丢弃第一个 n 元素后，返回由该流的 n元素组成的流
        System.out.println();
        System.out.println("丢弃之前流内元素总数:" + digitStr.stream().count()); // 输出: 14
        Stream<String> skipped = digitStr.stream().skip(3);
        System.out.println("丢弃之后流内元素总数:" + skipped.count());    // 输出: 11
        digitStr.stream().skip(3).forEach((s) -> System.out.print(s + "\t"));
        //输出: 4	5	6	7	8	9	10	2	3	4	5
    }

    @Test
    public void testSequenceAndParallel() {
        long t0 = System.nanoTime();
        int[] ans = IntStream.range(0, 1_000_000_0).filter(n -> n % 2 == 0).filter(n -> n % 3 == 0).toArray();
        long t1 = System.nanoTime();

        // 切换为并行流
        int[] b = IntStream.range(0, 1_000_000_0).parallel().filter(p -> p % 2 == 0).filter(n -> n % 3 == 0).toArray();
        long t2 = System.nanoTime();

        // 测试: serial 0.01s, parallel 0.01s
        System.out.printf("serial: %.2fs, parallel %.2fs%n", (t1 - t0) * 1e-9, (t2 - t1) * 1e-9);
    }
}

class LambdaClass {
    public static void forEg() {
        lambdaInterfaceDemo(() -> System.out.println("Lambda interface demo"));
    }

    //函数式接口参数
    static void lambdaInterfaceDemo(LambdaExpInterface i) {
        i.f();
    }
}

interface LambdaExpInterface {
    void f();
}

class ObjItem {

}
