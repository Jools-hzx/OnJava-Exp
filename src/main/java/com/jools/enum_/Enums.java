package com.jools.enum_;

import java.util.Random;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/26 16:43
 * @description: TODO
 */
public class Enums {

    private static Random rand = new Random(47);

    /**
     * 随机返回一个枚举类实例
     *
     * @param ec Class<T> T 是一个枚举的实例；通过传入 Class<T> 使得 class 对象变得可用
     */
    public static <T extends Enum<T>> T random(Class<T> ec) {
        /*
        getEnumConstants():
            Returns the elements of this enum class or
            null if this Class object does not represent an enum class.
        */
        return random(ec.getEnumConstants());
    }

    /**
     * 随机返回泛型数组中的其中一个实例
     *
     * @param values
     * @param <T>
     * @return 返回的对象类型则是确切的 enum 类型
     */
    public static <T> T random(T[] values) {
        return values[rand.nextInt(values.length)];
    }
}
