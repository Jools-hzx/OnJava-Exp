package com.jools.enum_;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/26 18:07
 * @description: TODO
 */
public enum OverrideConstantMethod {

    NUT, BOLT,
    WAHSER {     //相当于继承: Enum<OverrideConstantMethod>
        @Override
        void f() {
            System.out.println("Change operation to washing~~~");
        }
    };

    void f() {
        System.out.println("default behavior");
    }

    public static void main(String[] args) {
        OverrideConstantMethod[] values = OverrideConstantMethod.values();
        for (OverrideConstantMethod v : values) {
            v.f();
        }
        /*
         输出:
            default behavior
            default behavior
            Change operation to washing~~~
        */
    }
}
