package com.jools.generic_;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/21 16:48
 * @description: TODO
 */
public class CaptureConversion {

    static <T> void f1(Holder<T> holder) {
        T t = holder.get();
        System.out.println(t.getClass().getSimpleName());
    }

    static void f2(Holder<?> holder) {
        f1(holder); // 用捕获的类型来调用该方法
    }

    public static void main(String[] args) {
        Holder raw = new Holder<>(1);
        f1(raw);    // 无法推断具体类型: Unchecked assignment: 'com.jools.generic_.Holder' to 'com.jools.generic_.Holder<java.lang.Object>'
        f2(raw);    // 不产生告警

        Holder rawBasic = new Holder();
        // 无法推断具体类型: Unchecked call to 'set(T)' as a member of raw type 'com.jools.generic_.Holder
        rawBasic.set(new Object());

        f2(rawBasic);   // 不产生警告

        Holder<?> holder = new Holder<>(1.1);
        f1(holder); // 不产生警告
        f2(holder); // 不产生警告
    }
}
