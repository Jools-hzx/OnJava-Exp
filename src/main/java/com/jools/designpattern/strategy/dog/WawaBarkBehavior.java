package com.jools.designpattern.strategy.dog;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/2/3 10:51
 * @description: TODO
 */
public class WawaBarkBehavior implements BarkBehavior{
    @Override
    public void bark() {
        System.out.println("小狗汪汪叫！！！");
    }
}
