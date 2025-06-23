package com.jools.generic_;

import java.lang.reflect.Method;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/22 18:05
 * @description: TODO
 */
public class LatentReflection {

    public static void main(String[] args) {
        CommunicateReflectively.perform(new SmartDog());
        CommunicateReflectively.perform(new Mime());
    }
}

class CommunicateReflectively {

    public static void perform(Object speaker) {
        Class<?> spkr = speaker.getClass();
        try {
            try {
                Method speak = spkr.getMethod("speak");
                speak.invoke(speaker);
            } catch (Exception e) {
                System.out.println(speaker + " cannot speak!!!");
            }
            try {
                Method sit = spkr.getMethod("sit");
                sit.invoke(speaker);
            } catch (Exception e) {
                System.out.println(speaker + " cannot sit!!!");
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(speaker.toString(), e);
        }

        /*
         输出:
            Woof!
            Sitting
            Mime cannot speak!!!
            Mime cannot sit!!!
         */
    }
}

class SmartDog {

    public void speak() {
        System.out.println("Woof!");
    }

    public void sit() {
        System.out.println("Sitting");
    }

    public void reproduce() {
    }
}

class Mime {

    public void walkAgainstTheWind() {
        System.out.println("walkAgainstTheWind()");
    }

    public void set() {
        System.out.println("Pretending to sit");
    }

    public void pushInvisibleWalls() {
        System.out.println("pushInvisibleWalls()");
    }

    @Override
    public String toString() {
        return "Mime";
    }
}
