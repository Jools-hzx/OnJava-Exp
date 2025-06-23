package com.jools.refer;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/5/2 18:34
 * @description: TODO
 */
public class LocalCopy {

    public static Duplo g(Duplo v) {
        // 借助引入传递修改对象
        v.increment();
        return v;
    }

    public static Duplo f(Duplo v) {
        // 克隆, 形成本地副本
        v = v.clone();
        // 修改的是本地副本
        v.increment();
        return v;
    }

    public static void main(String[] args) {
        Duplo a = new Duplo(11);

        // 引用传递修改
        Duplo b = g(a);
        // 引用相等
        System.out.println("a == b: " + (a == b) + " \na: " + a + " \nb: " + b);

        Duplo c = new Duplo(47);
        // 本地副本修改
        Duplo d = f(c);
        System.out.println("c == d: " + (c == d) + " \nc: " + c + " \nd: " + d);
        /*
         输出结果:
            a == b: true
            a: 12
            b: 12
            c == d: false
            c: 47
            d: 48
        */
    }
}

class Duplo implements Cloneable {

    private int n;

    Duplo(int n) {
        this.n = n;
    }

    @Override
    protected Duplo clone() {
        try {
            return (Duplo) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public void increment() {
        n++;
    }

    @Override
    public String toString() {
        return Integer.toString(n);
    }
}
