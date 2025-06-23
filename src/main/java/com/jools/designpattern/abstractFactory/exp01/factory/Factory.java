package com.jools.designpattern.abstractFactory.exp01.factory;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/1/17 20:15
 * @description: TODO
 */
public abstract class Factory {

    public abstract AbstractProduct manufactureContainer();

    public abstract AbstractProduct manufactureMould();
}
