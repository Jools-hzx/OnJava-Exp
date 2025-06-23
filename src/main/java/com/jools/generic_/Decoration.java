package com.jools.generic_;

import java.util.Date;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/22 17:25
 * @description: TODO
 */

class DecBase {
    private String val;

    public void set(String val) {
        this.val = val;
    }

    public String get() {
        return val;
    }
}

// 装饰器类一: 继承 DecBase 基类
class Decorator extends DecBase {
    protected DecBase basic;

    Decorator(DecBase base) {
        this.basic = base;
    }

    @Override
    public void set(String val) {
        basic.set(val);
    }

    @Override
    public String get() {
        return basic.get();
    }
}

// 装饰器类二: 继承实现 TimeStamped 功能
class DecTimeStamped extends Decorator {
    private final long timeStamp;

    DecTimeStamped(DecBase base) {
        super(base);
        timeStamp = new Date().getTime();
    }

    public long getTimeStamp() {
        return timeStamp;
    }
}

// 装饰器类三: 继承实现 SerialNumbered 功能
class DecSerialNumber extends Decorator {
    private static long counter = 1;
    private final long serialNumber = counter++;

    DecSerialNumber(DecBase base) {
        super(base);
    }

    public long getSerialNumber() {
        return serialNumber;
    }
}

public class Decoration {
    public static void main(String[] args) {
        DecTimeStamped t1 = new DecTimeStamped(new DecBase());
        DecTimeStamped t2 = new DecTimeStamped(new DecSerialNumber(new DecBase()));
        t1.getTimeStamp();  // 支持
        t2.getTimeStamp();  // 支持
//        t2.getSerialNumber();   不可以使用

        DecSerialNumber s1 = new DecSerialNumber(new DecBase());
        DecSerialNumber s2 = new DecSerialNumber(new DecBase());
        s1.getSerialNumber();   // 支持
        s2.getSerialNumber();   // 支持
        // s2.getStamp() // 不可以使用
    }
}
