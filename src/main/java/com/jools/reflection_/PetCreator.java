package com.jools.reflection_;

import java.util.List;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/12 16:17
 * @description: TODO
 */
public class PetCreator extends Creator {

    // 存储所有字面量
    public static final List<Class<? extends Pet>> ALL_TYPES = List.of(
            Pet.class, Dog.class, Cat.class, Rodent.class,
            Mutt.class, Pug.class, EgyptianMau.class, Manx.class,
            Cymric.class, Rat.class, Mouse.class, Hamster.class
    );

    // 随机生成的类型; Mutt 字面量下标之后
    private static final List<Class<? extends Pet>> TYPES = ALL_TYPES.subList(
            ALL_TYPES.indexOf(Mutt.class),
            ALL_TYPES.size()
    );

    // 随机生成的类型
    @Override
    public List<Class<? extends Pet>> types() {
        return TYPES;
    }

    public static void main(String[] args) {
        System.out.println(TYPES);
        // 获取前 7 个的 Pet 类及其子类的集合;
        List<Pet> pets = new PetCreator().list(7);
        System.out.println(pets);

        /*
         输出:
          [class com.jools.reflection_.Mutt, class com.jools.reflection_.Pug,
          class com.jools.reflection_.EgyptianMau, class com.jools.reflection_.Manx,
          class com.jools.reflection_.Cymric, class com.jools.reflection_.Rat, class com.jools.reflection_.Mouse,
          class com.jools.reflection_.Hamster]

          [ com.jools.reflection_.Rat@17f052a3,
            com.jools.reflection_.Manx@2e0fa5d3,
            com.jools.reflection_.Cymric@5010be6,
            com.jools.reflection_.Mutt@685f4c2e,
            com.jools.reflection_.Pug@7daf6ecc,
            com.jools.reflection_.Cymric@2e5d6d97,
            com.jools.reflection_.Pug@238e0d81 ]
        */
    }
}
