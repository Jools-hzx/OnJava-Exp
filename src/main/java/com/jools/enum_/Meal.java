package com.jools.enum_;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/26 17:07
 * @description: TODO
 */
public class Meal {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            for (Course c : Course.values()) {
                // 选择随机一个食物分类下输出所有的枚举实例
                Food food = c.randomSelection();
                System.out.println(food);
            }
            System.out.println("**********");
        }

        /*
         输出结果:
            SPRING_ROLLS
            VINDALOO
            HERB_TEA
            **********
            SPRING_ROLLS
            BURRITO
            ESPRESSO
            **********
            SOUP
            PAD_THAI
            TEA
            **********
            SOUP
            LASAGNE
            TEA
            **********
            SALAD
            BURRITO
            LATTE
            **********
        */
    }
}
