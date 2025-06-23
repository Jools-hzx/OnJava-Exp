package com.jools.enum_;

import java.util.Objects;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/5/1 18:23
 * @description: TODO
 */
public class PetPatternMatch {

    static void careFor(Pet p) {
        // JDK 21 版本后支持模式匹配
        if (p instanceof Dog) {
            ((Dog) p).walk();
        } else if (p instanceof Fish) {
            ((Fish) p).changeWater();
        } else if (p instanceof Pet) {
            p.feed();
        }
    }
}

class Pet {
    void feed() {
    }
}

class Dog extends Pet {
    void walk() {
    }
}

class Fish extends Pet {
    void changeWater() {
    }
}
