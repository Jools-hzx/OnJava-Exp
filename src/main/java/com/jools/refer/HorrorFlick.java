package com.jools.refer;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/5/2 19:30
 * @description: TODO
 */
public class HorrorFlick {

    public static void main(String[] args) {
        Person p = new Person();
        Hero h = new Hero();
        Scientist s = new Scientist();
        MadScientist ms = new MadScientist();
        //(Person) p.clone();  编译错误 clone()' has protected access in 'java.lang.Object'
        //(Hero) h.clone();  编译错误 clone()' has protected access in 'java.lang.Object'

        s.clone(); // 编译通过
        ms.clone(); // 编译通过

        // 编译通过
        Scientist msClone = ms.clone();
    }
}

class Person { }

class Hero extends Person { }

class Scientist extends Person implements Cloneable {

    @Override
    protected Scientist clone() {
        try {
            return (Scientist) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}

class MadScientist extends Scientist {}
