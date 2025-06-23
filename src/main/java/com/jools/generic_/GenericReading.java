package com.jools.generic_;

import java.util.Arrays;
import java.util.List;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/20 19:34
 * @description: TODO
 */
public class GenericReading {

    static List<Apple> apples = Arrays.asList(new Apple());
    static List<Fruit> fruit = Arrays.asList(new Fruit());

    // 基于静态方法返回泛型类型实例
    static <T> T readExact(List<T> list) {
        return list.get(0);
    }

    static void f1() {
        Apple a = readExact(apples);    // 直接读取返回 Apple
        Fruit f = readExact(fruit); //  直接读取返回 Fruit
        f = readExact(apples);
    }

    static class Reader<T> {
        T readExact(List<T> list) {
            return list.get(0);
        }
    }

    static void f2() {
        Reader<Fruit> fruitReader = new Reader<>();
        Fruit f = fruitReader.readExact(fruit);
//        fruitReader.readExact(apples); 报错  因为 Reader<Fruit> 只能读取 Fruit; 无法转成 Apple
    }

    // 协变机制允许读取，禁止写入
    static class CovariantReader<T> {
        T readCovariant(List<? extends T> list) {
            return list.get(0);
        }
    }

    static void f3() {
        CovariantReader<Fruit> covariantReader = new CovariantReader<>();
        Fruit f = covariantReader.readCovariant(apples);    // 合法，协变性支持读取；但是统一读取 Fruit 类型
        f = covariantReader.readCovariant(fruit); // 合法
    }

    public static void main(String[] args) {
        f1();
        f2();
        f3();
    }
}
