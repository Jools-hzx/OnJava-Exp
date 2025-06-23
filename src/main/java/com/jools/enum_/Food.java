package com.jools.enum_;

/**
 * 你有一些类型互不相同的 food
 * 想要创建若干 enum 来组织它们，但是又希望它们仍然是 Food 类型
 */
public interface Food {

    enum Appetizer implements Food {
        SALAD, SOUP, SPRING_ROLLS
    }

    enum MainCourse implements Food {
        LASAGNE, BURRITO,
        PAD_THAI, LENTILS,
        HUMMOUS, VINDALOO
    }

    enum Coffee implements Food {
        BLACK_COFFEE, DECAF_COFFEE,
        ESPRESSO, LATTE,
        CAPPUCCINO, TEA, HERB_TEA
    }
}
