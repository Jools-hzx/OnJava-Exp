package com.jools.reflection_;

import java.lang.reflect.InvocationTargetException;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/11 21:59
 * @description: TODO
 */
class ID {
    private static long counter = 0;
    private final long id = counter++;

    @Override
    public String toString() {
        return Long.toString(id);
    }

    // 需要显式地提供无参构造器; 否则会报错: NoSuchMethodException
    public ID() {
    }
}


public class DynamicSupplier<T> implements Supplier<T> {

    private Class<T> type;

    public DynamicSupplier(Class<T> type) {
        this.type = type;
    }

    @Override
    public T get() {
        try {
            return type.getConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Stream.generate(new DynamicSupplier<>(ID.class))
                .skip(10)
                .limit(5)
                .forEach(System.out::println);
    }
}
