package com.jools.generic_;

import java.util.Objects;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/20 18:56
 * @description: TODO
 */
public class Holder<T> {

    private T value;

    public Holder() {
    }

    public Holder(T val) {
        this.value = val;
    }

    public void set(T val) {
        this.value = val;
    }

    public T get() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Holder && Objects.equals(value, ((Holder) obj).value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public static void main(String[] args) {

        Holder<Apple> apple = new Holder<>(new Apple());
        Apple a = apple.get();
        apple.set(a);
//        Holder<Fruit> fHolder = apple; 无法向上转型
        Holder<? extends Fruit> fruitHolder = apple;   // 支持
        Fruit fruit = fruitHolder.get();    // 读取，直接返回 Fruit
        a = (Apple) fruitHolder.get();      // 支持，强转为 Apple

        try {
            // 编译不报错，运行时报错
            Orange o = (Orange) fruitHolder.get();
        } catch (Exception e) {
            // 报错:java.lang.ClassCastException:
            // class com.jools.generic_.Apple cannot be cast to class com.jools.generic_.Orange (com.jools.generic_.Apple
            // and com.jools.generic_.Orange are in unnamed module of loader 'app')
            System.out.println(e);
        }
//        fruit.set(new Apple());  无法访问到 set() 方法
//        fruit.set(new Fruit());
        System.out.println(fruit.equals(a));    // true
    }
}
