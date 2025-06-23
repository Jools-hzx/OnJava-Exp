package com.jools.designpattern.strategy.dog;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/2/3 10:52
 * @description: TODO
 */
public class Dog {

    private BarkBehavior barkBehavior;


    public void barking() {
        if(barkBehavior != null) {
            barkBehavior.bark();
        }
    }

    public Dog() {
    }

    public void setBarkBehavior(BarkBehavior barkBehavior) {
        this.barkBehavior = barkBehavior;
    }
}
