package com.jools.reflection_;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/11 20:41
 * @description: TODO
 */

interface HasBatteries {
}

interface Waterproof {
}

interface Shoots {
}

class Toy {
    // 可以将下面这个无参构造器注释掉来看一下 NoSuchMethodError 的报错
    Toy() {
    }

    Toy(int i) {
    }
}

class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots {
    public FancyToy() {
        super(1);
    }
}

public class ToyTest {

    static void printInfo(Class cc) {
        System.out.println("Class name: " + cc.getName() +
                " is interface? [" + cc.isInterface() + "]");
        System.out.println("Simple name: " + cc.getSimpleName());
        System.out.println("Canonical name : " + cc.getCanonicalName());
    }

    public static void main(String[] args) {
        Class c = null;
        try {
            c = Class.forName("com.jools.reflection_.FancyToy");
        } catch (ClassNotFoundException e) {
            System.out.println("Can not find Fancy Toy");
            System.exit(1);
        }
        // 输出 Class 对象的信息
        printInfo(c);
        for (Class face : c.getInterfaces()) {
            printInfo(face);
        }
        // 得到其基类的 Class 对象
        Class up = c.getSuperclass();
        Object obj = null;
        try {
            // 实例化 Class 对象
            // obj = up.newInstance(); 是否是无参构造器 (老版本支持)
            obj = up.getDeclaredConstructor().newInstance();    // 更高版本推荐
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        // 输出 Class 对象的信息
        printInfo(obj.getClass());
    }
}
