package com.jools.generic_;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/21 20:50
 * @description: TODO
 */
public class PlainGenericInheritance {

    public static void main(String[] args) {
        DecBase base = new DecBase();
        Derived derived = new Derived();
        DerivedGS derivedGS = new DerivedGS();
        derivedGS.set(derived); // 执行的是 DerivedGS 中的 set

        derivedGS.set(base);    // 重载，不是重写；执行的是 GenericSetter 中的 set
    }
}

class GenericSetter<T> {    // 非自限定
    void set(T arg) {
        System.out.println("GenericSetter.set(Base)");
    }
}

// DerivedGS 继承自同样带有 set(Base) 方法的 GenericSetter<Base>; 该方法由泛型创建
class DerivedGS extends GenericSetter<DecBase> {
    void set(Derived derived) {
        System.out.println("DerivedGS.set(Derived)");
    }
}


