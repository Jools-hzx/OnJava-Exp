package com.jools.generic_;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/21 18:02
 * @description: TODO
 */

public class SelfBounding {

}

class A extends SelfBounded<A> {}
class B extends SelfBounded<A> {}   // 支持

class C extends SelfBounded<C> {
    C setAndGet(C arg) {
        set(arg);
        return get();
    }
}

class D {}

class F extends SelfBounded {}

class SelfBounded<T extends SelfBounded<T>> {
    T element;

    SelfBounded<T> set(T arg) {
        this.element = arg;
        return this;
    }

    T get() {
        return element;
    }
}