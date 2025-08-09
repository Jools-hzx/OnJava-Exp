package com.jools.designpattern.observer;

/**
 * @author Jools He
 * @date 2025/7/29 11:34
 * @description: TODO
 */
public class Main {

    public static void main(String[] args) {
        RandomNumberGenerator generator = new RandomNumberGenerator();
        Observer observer1 = new DigitObserver();
        Observer observer2 = new GraphObserver();

        generator.add(observer1);
        generator.add(observer2);

        generator.execute();
    }
}
