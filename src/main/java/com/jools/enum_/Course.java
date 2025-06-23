package com.jools.enum_;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/26 17:05
 * @description: TODO
 */
public enum Course {

    APPETIZER(Food.Appetizer.class),
    MAINCOURSE(Food.MainCourse.class),
    COFFEE(Food.Coffee.class);

    private Food[] vales;

    Course(Class<? extends Food> kind) {
        // 返回给枚举类所有实例；由于都实现了 Food 接口，借助 Food 向上转型接收
        this.vales = kind.getEnumConstants();
    }

    public Food randomSelection() {
        return Enums.random(vales);
    }
}
