package com.jools.generic_;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/21 21:06
 * @description: TODO
 */
public class CheckedList {

    static void oldStyleMethod(List probablyDogs) {
        probablyDogs.add(new Cat());
    }

    public static void main(String[] args) {
        ArrayList<Dog> dog1 = new ArrayList<>();
        oldStyleMethod(dog1);   // 可以传入 Cat

        List<Dog> dogs2 = Collections.checkedList(new ArrayList<>(), Dog.class);

        try {
            oldStyleMethod(dogs2);  // 抛出异常
        } catch (Exception e) {
            System.out.println("Expected: " + e);
            // 输出: Expected: java.lang.ClassCastException:
            // Attempt to insert class com.jools.generic_.Cat element into collection
            // with element type class com.jools.generic_.Dog
        }

        List<Pet> pets = Collections.checkedList(
                new ArrayList<>(),
                Pet.class
        );
        pets.add(new Cat());    // 支持放入 Pet 及其子类
        pets.add(new Dog());    // 支持放入 Pet 及其子类
    }
}

class Pet {}
class Cat extends Pet {}
class Dog extends Pet {}