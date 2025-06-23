package com.jools.enum_;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/26 15:56
 * @description: TODO
 */
public class EnumClass {

    public static void main(String[] args) {

        for (Shrubbery val : Shrubbery.values()) {
            // ordinal() 方法: 表示返回一个从 0 开始的 int 值，代表每个枚举实例的声明顺序
            System.out.println(val + " ordinal:" + val.ordinal());

            // Enum 类实现了 Comparable 接口; 可以进行比较；自动包含了 compareTo 方法
            System.out.println(val.compareTo(Shrubbery.CRAWLING));
            System.out.println(val.equals(Shrubbery.CRAWLING));
            System.out.println(val == Shrubbery.CRAWLING);

            // 输出这个枚举类所属的 ⌈外部包装类⌋
            System.out.println("DeclaringClass: " + val.getDeclaringClass());   // 输出: DeclaringClass: class com.jools.enum_.Shrubbery
            System.out.println(val.name());
            System.out.println("*******************");
        }

        // 根据字符串名称生成一个枚举值
        for (String s : "HANGING CRAWLING GROUND".split(" ")) {
            // 基于字符串名称生成 Shrubbery 类型的枚举类值
            Shrubbery shrubbery = Enum.valueOf(Shrubbery.class, s);
            System.out.println(shrubbery);
        }
    }
}

enum Shrubbery {
    GROUND("aaa"),
    CRAWLING("BBB"),
    HANGING("ccc");

    // 构造器的访问权限必须是包级或者是 private
    Shrubbery(String des) {
        this.des = des;
    }

    private String des;

    public String getDes() {
        return des;
    }

    @Override
    public String toString() {
        return this.getDeclaringClass().getSimpleName() +
                " desc:" + this.getDes().toUpperCase();
    }

    public static void main(String[] args) {
        for (Shrubbery v : Shrubbery.values()) {
            System.out.println(v + ": " + v.getDes());
        }
        /*
         输出结果:
            GROUND: aaa
            CRAWLING: BBB
            HANGING: ccc
        */
    }
}
