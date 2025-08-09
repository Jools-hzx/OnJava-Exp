package com.jools.designpattern.respchain;

/**
 * @author Jools He
 * @desc: 解决编号小于 limit 值的问题
 */
public class LimitSupport extends Support {

    private int limit;

    public LimitSupport(String name, int limit) {
        super(name);
        this.limit = limit;
    }

    @Override
    protected boolean resolve(Trouble t) {
        return t.getNumber() < limit;
    }
}
