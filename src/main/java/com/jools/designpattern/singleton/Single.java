package com.jools.designpattern.singleton;

/**
 * @author Jools He
 * @date 2025/6/22 13:48
 * @description: TODO
 */
public class Single<T> {

    private static Object single;

    public Single(T val) {
        if (single != null) {
            throw new RuntimeException(
                    "Attempt to reassign Single<" +
                            val.getClass().getSimpleName() + ">"
            );
        }
        // 具体类型由 val 决定
        single = val;
    }

    public T get() {
        return (T) single;
    }
}
