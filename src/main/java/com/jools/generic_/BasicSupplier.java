package com.jools.generic_;

import java.lang.reflect.InvocationTargetException;
import java.util.function.Supplier;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/18 19:10
 * @description: TODO
 */
public class BasicSupplier<T> implements Supplier<T> {

    private Class<T> type;

    public BasicSupplier(Class<T> type) {
        this.type = type;
    }

    @Override
    public T get() {
        try {
            return type.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // 基于类型标记生成默认的 Supplier
    public static <T> Supplier<T> create(Class<T> type) {
        return new BasicSupplier<>(type);
    }
}
