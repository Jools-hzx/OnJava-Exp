package com.jools.reflection;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/1/20 11:04
 * @description: TODO
 */
public class GenerateCls {

    public static void main(String[] args) throws ClassNotFoundException {

        //方式一: 知道具体类的情况下可以使用
        Class<?> cls = Obj.class;

        //方式二: 通过 'Class.forName()' 传入类的全路径获取
        cls = Class.forName("com.jools.reflection.Obj");

        //方式三: 通过对象实例 'instance.getClass()' 获取
        Obj obj = new Obj();
        cls = obj.getClass();

        //方式四: 通过类加载器的方式
        cls = ClassLoader.getSystemClassLoader().loadClass("com.jools.reflection.Obj");
    }
}

class Obj {
}
