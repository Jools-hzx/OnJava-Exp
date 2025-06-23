package com.jools.designpattern.singleton;

/**
 * @author Jools He
 * @date 2025/6/22 13:23
 * @description: TODO
 */

interface Resource<T> {

    T get();

    void set(T x);
}

final class IntegerSingleton implements Resource<Integer> {

    private static IntegerSingleton value = new IntegerSingleton();

    private Integer i = Integer.valueOf(0);

    private IntegerSingleton() {
        System.out.println("IntegerSingleton()");
    }

    public static IntegerSingleton getInstance() {
        return value;
    }

    @Override
    public synchronized Integer get() {
        return i;
    }

    @Override
    public synchronized void set(Integer x) {
        i = x;
    }
}

public class SingletonPattern {

    // 展示 Resource 接口内的值
    public static <T> void show(Resource<T> r) {
        T val = r.get();
        System.out.println(val);
    }

    // 设置 Resource 实例内的值‘
    public static <T> void put(Resource<T> r, T val) {
        r.set(val);
    }

    public static void main(String[] args) {
        System.out.println("Inside main()");
        IntegerSingleton iSingleton1 = IntegerSingleton.getInstance();
        IntegerSingleton iSingleton2 = IntegerSingleton.getInstance();
        show(iSingleton1);      // 输出 0
        put(iSingleton2, 9);
        show(iSingleton2);      // 输出 1

        /*
         仅输出:
            Inside main()
            IntegerSingleton()
        */
    }
}
