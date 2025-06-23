package com.jools.generic_;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/19 18:24
 * @description: TODO
 */
public class CreatorGeneric {

    public static void main(String[] args) {

        GenericWithCreate<X> genericCreator = new XCreator();
        genericCreator.create();
        ((XCreator) genericCreator).show();
        // 输出: com.jools.generic_.X
    }
}

class XCreator extends GenericWithCreate<X> {

    // 模板实现类重写该方法；返回 X 的实例对象
    @Override
    X create() {
        return new X();
    }

    // 子类实例方法，输出父类字段 element 的类型
    void show() {
        System.out.println(super.element.getClass().getName());
    }
}

class X { }

// 模板设计模式：直接借助构造器创建一个 T 类型的实例
abstract class GenericWithCreate<T> {

    final T element;

    public GenericWithCreate() {
        element = create();
    }

    abstract T create();
}
