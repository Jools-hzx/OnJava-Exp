package com.jools.designpattern.singleton;

import lombok.Getter;

/**
 * @author Jools He
 * @date 2025/7/25 22:27
 * @description: TODO
 */
public class HungerSingleton {

    @Getter
    private static HungerSingleton instance = new HungerSingleton();

    private HungerSingleton() {}

}
