package com.jools.generic_;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/21 20:36
 * @description: TODO
 */
public class CovariantReturnTypes {
    void test(DerivedGetter d) {
        Derived D2 = d.get();
    }
}

class Base {}
class Derived extends DecBase {}

interface OrdinaryGetter {
    // 原始接口方法返回类型: 基类 Base
    DecBase get();
}

interface DerivedGetter extends OrdinaryGetter {

    // 重写方法的返回类型变化; Derived 继承自 Base
    @Override
    Derived get();
}