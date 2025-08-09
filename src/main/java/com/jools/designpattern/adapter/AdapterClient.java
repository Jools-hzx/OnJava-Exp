package com.jools.designpattern.adapter;

/**
 * @author Jools He
 * @date 2025/7/13 22:58
 * @description: TODO
 */
public class AdapterClient {
    public static void main(String[] args) {
        Print p = new PrintBanner(new Banner("Hi!! I'am Jools He!!!"));
        p.printWeak();  // 适配 -> 弱化输出
        p.printStrong();    // 适配 -> 强化输出

        /*
         输出结果:
          (Hello)
          *Hello*
        */
    }
}
