package com.jools.generic_;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/18 16:28
 * @description: TODO
 */
public class ObjectHolder {

    private Object a;

    public ObjectHolder(Object o) {
        this.a = a;
    }

    public void set(Object o) {
        this.a = o;
    }

    public Object get() {
        return a;
    }

    public static void main(String[] args) {
        ObjectHolder h2 = new ObjectHolder(new Automobile());
        Automobile a = (Automobile) h2.get();
        h2.set("Not an Automobile");    // 设置为 String
        String newObj = (String) h2.get();
        h2.set(1);  // 自动装箱为 Integer
        Integer newObj2 = (Integer) h2.get();
    }
}

class GenericHolder<T> {

    private T a;

    public GenericHolder() {
    }

    public void set(T a) {
        this.a = a;
    }

    public T get() {
        return a;
    }

    public static void main(String[] args) {
        GenericHolder<Automobile> h3 = new GenericHolder<Automobile>();
        h3.set(new Automobile());
        Automobile a = h3.get();
//        h3.set("Not an Automobile"); // 报错，编译错误
    }
}

class Automobile {
}

class Holder1 {

    private Automobile e;

    public Holder1(Automobile e) {
        this.e = e;
    }

    Automobile get() {
        return e;
    }
}
