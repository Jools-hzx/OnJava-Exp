package com.jools.generic_;

import java.util.Collection;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/22 19:50
 * @description: TODO
 */
public class Suppliers {

    /**
     * 填充一个集合
     *
     * @param factory 泛型类型位集合及其子类型
     * @param gen     生成
     * @param n       个数
     */
    public static <T, C extends Collection<T>> C create(Supplier<C> factory,
                                                        Supplier<T> gen,
                                                        int n) {
        return Stream.generate(gen)
                .limit(n)
                .collect(factory, C::add, C::addAll);
    }

    /**
     * 向已有的集合放入元素
     *
     * @param col  Collection 类及其子类
     * @param gen 生成方式
     * @param n  填充个数
     */
    public static <T, C extends Collection<T>> C fill(C col, Supplier<T> gen, int n) {
        Stream.generate(gen)
                .limit(n)
                .forEach(col::add);
        return col;
    }

    /**
     * 使用未绑定的方法引用生成更为通用的方法
     * @param holder holder 含有用于添加元素的方法
     * @param adder  生成 A 方法
     * @param n 个数
     */
    public static <H, A> H fill(H holder,
                                BiConsumer<H, A> adder,
                                Supplier<A> gen,
                                int n) {
        Stream.generate(gen)
                .limit(n)
                .forEach(a -> adder.accept(holder, a));
        return holder;
    }
}
