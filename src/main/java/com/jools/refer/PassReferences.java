package com.jools.refer;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/5/2 17:51
 * @description: TODO
 */
public class PassReferences {

    public static void f(PassReferences p) {
        System.out.println("h inside f():" + p);
    }

    public static void main(String[] args) {
        PassReferences p = new PassReferences();
        System.out.println("p inside main():" + p);
        // 传递对象到方法内
        f(p);
        /*
         输出结果:
            p inside main():com.jools.refer.PassReferences@4d405ef7
            h inside f():com.jools.refer.PassReferences@4d405ef7
         */
    }
}
