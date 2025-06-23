package com.jools.designpattern.singleton;

/**
 * @author Jools He
 * @date 2025/6/22 13:59
 * @description: TODO
 */
public class MyString {

    private String s;

    public MyString(String s) {
        this.s = s;
    }

    @Override
    public synchronized String toString() {
        return s;
    }

    // 修改内容
    public synchronized void change(String s) {
        this.s = s;
    }

    public static void main(String[] args) {
        Single<MyString> x = new Single<>(new MyString("Hello"));
        System.out.println(x.get());
        x.get().change("World!");
        System.out.println(x.get());

        /*
         输出:
            Hello
            World!
        */
    }
}
