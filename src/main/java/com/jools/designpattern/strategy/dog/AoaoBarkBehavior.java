package com.jools.designpattern.strategy.dog;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/2/3 10:52
 * @description: TODO
 */
public class AoaoBarkBehavior implements BarkBehavior{
    @Override
    public void bark() {
        System.out.println("小狗嗷嗷叫！！！！");
    }
}
