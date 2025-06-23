package com.jools.reflection_;

import java.util.HashMap;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/12 16:02
 * @description: TODO
 */
public class PetCounter {

    static class Counter extends HashMap<String, Integer> {

        public void count(String type) {
            Integer quantity = get(type);
            if (quantity == null) {
                put(type, 1);
            } else {
                put(type, quantity + 1);
            }
        }
    }

    private Counter counter = new Counter();

    private void countPet(Pet pet) {
        System.out.print(pet.getClass().getSimpleName() + " -> ");
        if (pet instanceof Pet) {
            counter.count("Pet");
        }
        if (pet instanceof Dog) {
            counter.count("Dog");
        }
        if (pet instanceof Mutt) {
            counter.count("Mutt");
        }
        if (pet instanceof EgyptianMau) {
            counter.count("EgyptianMau");
        }
        if (pet instanceof Manx) {
            counter.count("Manx");
        }
        if (pet instanceof Cymric) {
            counter.count("Cymric");
        }
        if (pet instanceof Rodent) {
            counter.count("Rodent");
        }
        if (pet instanceof Rat) {
            counter.count("Rat");
        }
        if (pet instanceof Mouse) {
            counter.count("Mouse");
        }
        if (pet instanceof Hamster) {
            counter.count("Hamster");
        }
    }

    // 统计生成的各个实例数目
    public void count(Creator creator) {
        // 获取一个流并且判断实例对象的类型
        creator.stream().limit(20).forEach(this::countPet);
        System.out.println();
        // 输出 HashMap 实例
        System.out.println(counter);
    }

    public static void main(String[] args) {
        new PetCounter().count(new PetCreator());
        /*
         输出结果:
            Rat -> Manx -> Cymric -> Mutt -> Pug -> Cymric ->
            Pug -> Manx -> Cymric -> Rat -> EgyptianMau ->
            Hamster -> EgyptianMau -> Mutt -> Mutt -> Cymric ->
            Mouse -> Pug -> Mouse -> Cymric ->

            {EgyptianMau=2, Rat=2, Cymric=5, Mouse=2, Manx=7, Rodent=5, Mutt=3, Dog=6, Pet=20, Hamster=1}
        */
    }
}
