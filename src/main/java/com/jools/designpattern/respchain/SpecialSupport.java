package com.jools.designpattern.respchain;

/**
 * @author Jools He
 * @date 2025/7/28 16:45
 * @description: TODO
 */
public class SpecialSupport extends Support{

    private int number;

    // 只能解决指定编号的问题
    public SpecialSupport(String name, int n) {
        super(name);
        this.number = n;
    }

    @Override
    protected boolean resolve(Trouble t) {
        return t.getNumber() == number;
    }
}
