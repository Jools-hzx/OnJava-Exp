package com.jools.collections_;

import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Jools He
 * @version 1.0
 * @description: 自动创建并填充 Map 工具类
 */
public class FillMap {

    /**
     * 借助流生成并填充 Map
     *
     * @param pairGen
     * @param size
     */
    public static <K, V> Map<K, V> basic(Supplier<Pair<K, V>> pairGen, int size) {
        return Stream.generate(pairGen)
                .limit(size)
                .collect(Collectors.toMap(
                        Pair::key,
                        Pair::value));
    }

    /**
     * 借助流生成并填充 Map; 分别指定 Key 生成函数和 Value 生成函数
     *
     * @param keyGen Key 的生成函数
     * @param valGen Value 的生成函数
     * @param size   生成个数
     */
    public static <K, V> Map<K, V> basic(Supplier<K> keyGen, Supplier<V> valGen, int size) {
        return Stream.generate(() -> Pair.make(keyGen.get(), valGen.get()))
                .limit(size)
                .collect(Collectors.toMap(
                        Pair::key,
                        Pair::value));
    }

    /**
     * 借助流生成并填充 Map; 分别指定 Key 生成函数、Value 生成函数和 Map 类型
     *
     * @param keyGen      Key 的生成函数
     * @param valGen      Value 的生成函数
     * @param mapSupplier Map 类型
     * @param size        生成个数
     */
    public static <K, V, M extends Map<K, V>> M create(Supplier<K> keyGen,
                                                       Supplier<V> valGen,
                                                       Supplier<M> mapSupplier,
                                                       int size) {
        return Stream.generate(() -> Pair.make(keyGen.get(), valGen.get()))
                .limit(size)
                .collect(Collectors.toMap(
                        Pair::key,
                        Pair::value,
                        (existing, replacement) -> {
                            throw new IllegalStateException("Duplicate key encountered: " + existing);
                        },
                        mapSupplier));
    }
}
