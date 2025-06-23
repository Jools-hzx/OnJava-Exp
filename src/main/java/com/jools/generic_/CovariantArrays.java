package com.jools.generic_;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/20 18:20
 * @description: TODO
 */
public class CovariantArrays {

    public static void main(String[] args) {
        Fruit[] fruits = new Apple[10];
        fruits[0] = new Apple();
        fruits[1] = new Jonathan();

        // 运行时类型是 Apple[]; 而不是 fruit[] 或者 Orange[]
        try {
            // 编译器运行添加 Fruit
            fruits[0] = new Fruit();
        } catch (Exception e) {
            // 输出: java.lang.ArrayStoreException: com.jools.generic_.Fruit
            System.out.println(e);
        }
        try {
            // 编译器允许添加 Orange
            fruits[0] = new Orange();
        } catch (Exception e) {
            // 输出: java.lang.ArrayStoreException: com.jools.generic_.Orange
            System.out.println(e);
        }
    }
}

class Fruit {}
class Apple extends Fruit {}
class Jonathan extends Apple {}

class Orange extends Fruit {}
