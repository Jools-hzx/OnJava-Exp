package com.jools.designpattern.respchain;

/**
 * @author Jools He
 * @description: Support 子类 - 不解决问题，总返回 false
 */
public class NoSupport extends Support{

    public NoSupport(String name) {
        super(name);
    }

    @Override
    protected boolean resolve(Trouble t) {
        return false;
    }
}
