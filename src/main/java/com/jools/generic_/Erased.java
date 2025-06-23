package com.jools.generic_;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/19 17:42
 * @description: TODO
 */
public class Erased<T> {

    private final int SIZE = 100;

    public void f(Object arg) {
        //'Object' cannot be safely cast to 'T'
//        if (arg instanceof T) {
//        }

        //Type parameter 'T' cannot be instantiated directly
//        T var = new T();

        //Type parameter 'T' cannot be instantiated directl
//        T[] array = new T[SIZE];

        //warning: [unchecked] unchecked cast
        T[] arr = (T[]) new Object[SIZE];
    }
}
