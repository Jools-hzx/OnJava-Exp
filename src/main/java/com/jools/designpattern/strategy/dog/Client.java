package com.jools.designpattern.strategy.dog;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/2/3 10:53
 * @description: TODO
 */
public class Client {

    public static void main(String[] args) {

        Dog dog = new Dog();
        dog.setBarkBehavior(new WawaBarkBehavior());

        dog.barking();

        dog.setBarkBehavior(new AoaoBarkBehavior());
        dog.barking();

        /*
         输出:
            小狗汪汪叫！！！
            小狗嗷嗷叫！！！！
        */
    }
}
