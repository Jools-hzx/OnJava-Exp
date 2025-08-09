package com.jools.designpattern.flyweight.security;

/**
 * @author Jools He
 * @date 2025/7/29 21:45
 * @description: TODO
 */
public class Main {

    public static void main(String[] args) {
        SecurityMgr mgr = SecurityMgr.getInstance();
        // 先登录
        mgr.login("张三");
        mgr.login("李四");

        boolean f1 = mgr.hasPermit("张三", "人员列表", "查看");
        boolean f2 = mgr.hasPermit("李四", "薪资数据", "查看");

        System.out.println("f1 ==" + f1);
        System.out.println("f2 ==" + f2);

        for (int i = 0; i < 3; i++) {
            mgr.login("张三" + i);
            mgr.hasPermit("张三" + i, "薪资数据", "查看");
        }

        /*
         输出结果:
            fm==com.jools.designpattern.flyweight.security.AuthorizationFlyweight@6433a2
            fm==com.jools.designpattern.flyweight.security.AuthorizationFlyweight@6433a2
            fm==com.jools.designpattern.flyweight.security.AuthorizationFlyweight@5910e440
            f1 ==true
            f2 ==true
            fm==com.jools.designpattern.flyweight.security.AuthorizationFlyweight@6433a2
            fm==com.jools.designpattern.flyweight.security.AuthorizationFlyweight@6433a2
            fm==com.jools.designpattern.flyweight.security.AuthorizationFlyweight@6433a2
        */
    }
}
