package com.jools.refer;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/5/3 18:16
 * @description: TODO
 */
public class Immutable2 {

    private int data;

    public Immutable2(int data) {
        this.data = data;
    }

    public int read() {
        return data;
    }

    public boolean nonzero() {
        return data != 0;
    }

    public Immutable2 add(int x) {
        return new Immutable2(data + x);
    }

    public Immutable2 multi(int x) {
        return new Immutable2(data * x);
    }

    // 转变回不可变类
    public Mutable makeMutable() {
        return new Mutable(data);
    }

    // 每次返回新的 Immutable2 实例
    public static Immutable2 modify1(Immutable2 y) {
        Immutable2 val = y.add(12);
        val = val.multi(3);
        val = val.add(11);
        val = val.multi(2);
        return val;
    }

    // 得到与 modify1 相等的结果
    public static Immutable2 modify2(Immutable2 y) {
        Mutable m = y.makeMutable();
        return m.add(12).multi(3).makeImmutable2();
    }

    public static void main(String[] args) {
        Immutable2 i2 = new Immutable2(47);
        Immutable2 r1 = modify1(i2);
        Immutable2 r2 = modify1(i2);
        System.out.println("i2 = " + i2.read());
        System.out.println("r1 = " + r1.read());
        System.out.println("r2 = " + r2.read());
        /*
         输出结果:
            i2 = 47
            r1 = 376
            r2 = 376
        */
    }
}

class Mutable {

    private int data;

    Mutable(int data) {
        this.data = data;
    }

    public Mutable multi(int x) {
        data *= x;
        return this;
    }

    public Mutable add(int x) {
        data += x;
        return this;
    }

    // 转变回可变类
    public Immutable2 makeImmutable2() {
        return new Immutable2(data);
    }
}
