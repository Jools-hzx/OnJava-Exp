package com.jools.designpattern.template;

/**
 * @author Jools He
 * @date 2025/7/20 11:37
 * @description: TODO
 */
public class TemplateClient {

    public static void main(String[] args) {
        // 生成一个持有 'H' 字符擦护士那个 CharDisplay 实例
        AbstractDisplay d1 = new CharDisplay('H');
        // 持有 Hello World 字符串的 StringDisplay 实例
        AbstractDisplay d2 = new StringDisplay("Hello World!!");
        // 持有 你好，世界! 字符串的 StringDisplay 实例
        AbstractDisplay d3 = new StringDisplay("你好；世界！");

        // 由于三个实例都是 AbstractDisplay 的实现子类; 可以通过向上转型调用 display()
        d1.display();
        d2.display();
        d3.display();

        /*
         输出结果:
         <<HHHHH>>
        +-------------+
        |Hello World!!|
        |Hello World!!|
        |Hello World!!|
        |Hello World!!|
        |Hello World!!|
        +-------------+
        +------------------+
        |你好；世界！|
        |你好；世界！|
        |你好；世界！|
        |你好；世界！|
        |你好；世界！|
        +------------------+
        */
    }
}
