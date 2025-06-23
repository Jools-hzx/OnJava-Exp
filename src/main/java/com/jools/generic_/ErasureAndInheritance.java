package com.jools.generic_;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/19 17:21
 * @description: TODO
 */
public class ErasureAndInheritance {

    public static void main(String[] args) {
        // Derived2 继承自 GenericBase 但是并未包含泛型参数; 编译器并未给出警告
        Derived2 d2 = new Derived2();
        Object obj = d2.get();
        d2.set(obj);    // 直到 set() 时，警告才出现
    }
}

class Derived1<T> extends GenericBase<T> {}
class Derived2 extends GenericBase {}   // 不会产生错误

//class Derived3 extends GenericBase<?> {}   报错

class GenericBase<T> {

    private T element;

    public void set(T arg) {
        element = arg;
    }

    public T get() {
        return element;
    }
}
