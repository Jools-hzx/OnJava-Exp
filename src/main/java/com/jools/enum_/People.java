package com.jools.enum_;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/5/2 17:04
 * @description: TODO
 */
public class People {

    static String categorize(Person person) {
//        return switch(person) {
//            case Person p && p.age() > 40 -> p + " is middle aged";
//            case Person p && (p.name().contains("D") || p.age() == 14) -> p + " is not a centenarian";
//            case Person p && !(p.age() >= 100) -> p + " is not a centenarian";
//            case Person p -> p + " Everyone else";
//        };
        return null;
    }
}

record Person(String name, int age) {
}
