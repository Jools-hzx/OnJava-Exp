package com.jools.generic_;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/19 17:01
 * @description: TODO
 */
public class Manipulation {

    public static void main(String[] args) {

        HasF hf = new HasF();
        Manipulator<HasF> manipulator = new Manipulator<>(hf);
        manipulator.manipulate();
    }
}

class Manipulator2<T extends HasF> {

    private T obj;

    public Manipulator2(T obj) {
        this.obj = obj;
    }

    public void manipulate() {
        obj.f();
    }
}

class Manipulator<T> {
    private T obj;

    public Manipulator(T obj) {
        this.obj = obj;
    }

    public void manipulate () {
        // Cannot resolve method 'f' in 'T'
//        obj.f();
    }
}

class HasF {
    public void f() {
        System.out.println("This is" + this.getClass().getSimpleName() + " f()");
    }
}
