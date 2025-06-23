package com.jools.reflection_;

import cn.hutool.core.lang.Pair;

import java.util.HashMap;
import java.util.stream.Collectors;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/12 16:32
 * @description: TODO
 */
public class PetCounter3 {

    static class Counter extends HashMap<Class<? extends Pet>, Integer> {

        public Counter() {
            super(PetCreator.ALL_TYPES
                    .stream()
                    .map(t -> Pair.of(t, 0))
                    .collect(Collectors.toMap(
                            Pair::getKey,
                            Pair::getValue))
            );
        }

        public void count(Pet pet) {
            // 直接借助 Class.isInstance() 方法;
            // 动态验证对象类型的方式
            entrySet().stream()
                    .filter(p -> p.getKey().isInstance(pet))
                    .forEach(pair -> put(pair.getKey(), pair.getValue() + 1));
        }

        @Override
        public String toString() {
            String result = entrySet().stream().map(
                    p -> String.format(
                            "%s=%s",
                            p.getKey().getSimpleName(),
                            p.getValue())
            ).collect(Collectors.joining(", "));
            return "{" + result + "}";
        }
    }

    public static void main(String[] args) {
        Counter petCount = new Counter();
        new PetCreator().stream()
                .limit(20)
                .peek(petCount::count)  // 中间操作，更新该子类对应的基类的个数
                .forEach(p -> System.out.print(p.getClass().getSimpleName() + " -> "));
        System.out.println("\n" + petCount);

        /*
          输出结果:
          Rat -> Manx -> Cymric -> Mutt -> Pug -> Cymric -> Pug -> Manx -> Cymric ->
          Rat -> EgyptianMau -> Hamster -> EgyptianMau -> Mutt -> Mutt -> Cymric ->
          Mouse -> Pug -> Mouse -> Cymric ->

          {Cat=9, Mutt=3, Pug=3, EgyptianMau=2, Rat=2, Pet=20, Dog=6, Manx=7, Hamster=1, Mouse=2, Rodent=5, Cymric=5}
        */
    }
}
