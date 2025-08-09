package com.jools.designpattern.respchain;

import lombok.Setter;

/**
 * @author Jools He
 * @desc: 解决问题的抽象类
 */
public abstract class Support {

    // 解决的问题实例名称
    private String name;

    // 下一个解决问题的对象, 待推卸的目标
    private Support next;

    public Support(String name) {
        this.name = name;
    }

    // 设置下一个解决问题的对象; 并且需要返回 next
    public Support setNext(Support next) {
        this.next = next;
        return next;
    }

    @Override
    public String toString() {
        return "[" + "name='" + name + ']';
    }

    // 解决问题的步骤
    public final void support(Trouble t) {
        if (resolve(t)) {
            done(t);
        } else if (next != null) {
            next.support(t);
        } else {
            fail(t);
        }
    }

    // 解决问题的方法
    protected abstract boolean resolve(Trouble t);

    // 解决完毕
    protected void done(Trouble t) {
        System.out.println(t + " is resolved by" + this + ".");
    }

    // 未解决完毕
    protected void fail(Trouble t) {
        System.out.println(t + " cannot be resolved.");
    }
}
