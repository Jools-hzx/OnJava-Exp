package com.jools.generic_;


import java.util.Date;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/22 17:03
 * @description: TODO
 */
public class Mixins {

    public static void main(String[] args) {
        Mixin m1 = new Mixin(), m2 = new Mixin();
        m1.set("test string 1");    // 基类接口实现方法 set()
        m2.set("test string 2");
        // 分别调用接口实现方法 get() TimeStamped 接口实现方法 getStamp() SerialNumbered 接口实现方法 getSerialNumber()
        System.out.println(m1.get() + " " + m1.getStamp() + " " + m1.getSerialNumber());
        System.out.println(m2.get() + " " + m2.getStamp() + " " + m2.getSerialNumber());

        /*
        输出:
        test string 1 1745313374043 1
        test string 2 1745313374043 2
         */
    }
}

// TimeStamped 接口，返回 Stamp
interface TimeStamped {
    long getStamp();
}

// SerialNumbered 接口，返回 SerialNumber
interface SerialNumbered {
    long getSerialNumber();
}

// 基础接口
interface Basic {
    void set(String val);

    String get();
}

class SerialNumberedImp implements SerialNumbered {

    private static long counter = 1;
    private final long serialNumber = counter++;

    @Override
    public long getSerialNumber() {
        return serialNumber;
    }
}

class BasicImp implements Basic {

    private String val;

    @Override
    public void set(String val) {
        this.val = val;
    }

    @Override
    public String get() {
        return val;
    }
}

class Mixin extends BasicImp implements TimeStamped, SerialNumbered {

    private TimeStamped timeStamped = new TimeStampedImp();
    private SerialNumbered serialNumbered = new SerialNumberedImp();

    @Override
    public long getStamp() {
        return this.timeStamped.getStamp();
    }

    @Override
    public long getSerialNumber() {
        return this.serialNumbered.getSerialNumber();
    }
}


class TimeStampedImp implements TimeStamped {

    private final long timeStamp;

    TimeStampedImp() {
        timeStamp = new Date().getTime();
    }

    @Override
    public long getStamp() {
        return timeStamp;
    }
}
