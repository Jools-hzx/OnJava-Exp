package com.jools.generic_;

import java.util.function.Consumer;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/22 19:35
 * @description: TODO
 */

class PerformingDogA extends Dog {
    public void speak() {
        System.out.println("Woof!!!");
    }

    public void sit() {
        System.out.println("Sitting!");
    }

    public void reproduce() {
    }
}


class RobotA {
    public void speak() {
        System.out.println("Woof!!!");
    }

    public void sit() {
        System.out.println("Sitting!");
    }

    public void reproduce() {
    }
}

class CommunicateA {
    public static <P> void perform(P performer, Consumer<P> action1, Consumer<P> action2) {
        action1.accept(performer);
        action2.accept(performer);
    }
}

public class DogsAndRobotMethodReferences {

    public static void main(String[] args) {
        CommunicateA.perform(new PerformingDogA(), PerformingDogA::speak, PerformingDogA::sit);
        CommunicateA.perform(new RobotA(), RobotA::speak, RobotA::sit);
        CommunicateA.perform(new Mime(), Mime::walkAgainstTheWind, Mime::pushInvisibleWalls);
        /*
         输出结果:
            Woof!!!
            Sitting!
            Woof!!!
            Sitting!
            walkAgainstTheWind()
            pushInvisibleWalls()
        */
    }
}
