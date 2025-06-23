package com.jools.designpattern.adapt_;

/**
 * @author Jools He
 * @date 2025/6/22 23:13
 * @description: TODO
 */
public class AdaptationDemo {

    public static void main(String[] args) {
        WhatIUse whatIUse = new WhatIUse();
        WhatIHave whatIHave = new WhatIHave();

        // 方法 1
        ProxyAdapter proxyAdapter = new ProxyAdapter(whatIHave);
        whatIUse.op(proxyAdapter);

        // 方式 2
        WhatIUse2 whatIUse2 = new WhatIUse2();
        whatIUse2.op(whatIHave);

        // 方式 3
        WhatIHave2 whatIHave2 = new WhatIHave2();
        whatIUse.op(whatIHave2);

        // 方式 4
        WhatIHave3 whatIHave3 = new WhatIHave3();
        whatIUse.op(whatIHave3.whatIWant());

        /*
         输出:
            Inside ProxyAdapter - f():
            Adaption 02 - pass Argument op():
            Inside ProxyAdapter - f():
            Adaption 03 - Child f():
            Adaption 04 - Inner Class f():
        */
    }
}

class WhatIHave {

    public void g() {
    }

    public void h() {
    }
}

interface WhatIWant {
    void f();
}

class WhatIUse {

    // 入参: 原始处理器
    public void op(WhatIWant wiw) {
        wiw.f();
    }
}

// 实现方式 1: 作为字段，使用待适配对象的原始方法
class ProxyAdapter implements WhatIWant {

    WhatIHave whatIHave;

    ProxyAdapter(WhatIHave have) {
        whatIHave = have;
    }

    @Override
    public void f() {
        System.out.println("Inside ProxyAdapter - f():");
        whatIHave.h();
        whatIHave.g();
    }
}


class WhatIUse2 extends WhatIUse {

    // 入参: 传入 op() 中使用的适配器
    public void op(WhatIHave h) {
        System.out.println("Adaption 02 - pass Argument op():");
        // 实现方式 2:  WhatIHave 中的方法实现行为
        new ProxyAdapter(h).f();
    }
}


// 实现方式 3: 借助实现接口 WhatIWant 并继承 WhatIHave 在其子类中构造适配器;
// 复用父类方法
class WhatIHave2 extends WhatIHave implements WhatIWant {

    @Override
    public void f() {
        System.out.println("Adaption 03 - Child f():");
        g();
        h();
    }
}

// 实现方法 4: 使用内部类
// 继承: 复用原始 WhatIHave
class WhatIHave3 extends WhatIHave {

    private final class InnerAdapter implements WhatIWant {
        @Override
        public void f() {
            System.out.println("Adaption 04 - Inner Class f():");
            g();
            h();
        }
    }

    // 提供方法: 返回适配器 WhatIWant 的实现类
    public WhatIWant whatIWant() {
        return new InnerAdapter();
    }
}
