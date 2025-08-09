package com.jools.designpattern.respchain;

/**
 * @author Jools He
 * @desc: 解决奇数编号问题
 */
public class OddSupport extends Support {

    public OddSupport(String name) {
        super(name);
    }

    @Override
    protected boolean resolve(Trouble t) {
        return t.getNumber() % 2 != 0;
    }
}
