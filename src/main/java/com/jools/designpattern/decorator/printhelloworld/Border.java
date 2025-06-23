package com.jools.designpattern.decorator.printhelloworld;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/2/4 10:08
 * @description: TODO
 */
public abstract class Border extends Display {

    protected Display display;

    protected Border(Display display) {
        this.display = display;
    }
}
