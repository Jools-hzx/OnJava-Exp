package com.jools.generic_;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/19 17:46
 * @description: TODO
 */
public class ClassTypeCapture<T> {

    Class<T> kind;

    public ClassTypeCapture(Class<T> kind) {
        this.kind = kind;
    }

    public boolean f(Object arg) {
        return kind.isInstance(arg);
    }

    public static void main(String[] args) {
        ClassTypeCapture<Building> ctt1 = new ClassTypeCapture<>(Building.class);
        System.out.println(ctt1.f(new Building()));     // true
        System.out.println(ctt1.f(new House()));        // true - House 为 Building 的子类

        ClassTypeCapture<House> ctt2 = new ClassTypeCapture<>(House.class);
        System.out.println(ctt2.f(new Building()));     // false
        System.out.println(ctt2.f(new House()));        // true
    }
}

class Building { }

class House extends Building { }
