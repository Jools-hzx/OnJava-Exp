package com.jools.reflection_;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/12 17:24
 * @description: TODO
 */
public class PetCounter4 {

    public static void main(String[] args) {

        TypeCounter counter = new TypeCounter(Pet.class);
        // 基于字面量统计前 20 个 Pet 的类型并计数
        new PetCreator()
                .stream()
                .limit(20)
                .peek(counter::count)
                .forEach(p -> System.out.print(p.getClass().getSimpleName() + " "));
        System.out.println("\n" + counter);
        /*
         输出:
         Rat Manx Cymric Mutt Pug Cymric Pug Manx Cymric Rat EgyptianMau
         Hamster EgyptianMau Mutt Mutt Cymric Mouse Pug Mouse Cymric

         {
              EgyptianMau=2,
              Mouse=2,
              Cymric=5,
              Pet=20,
              Dog=6,
              Rodent=5,
              Manx=7,
              Hamster=1,
              Mutt=3,
              Cat=9,
              Rat=2,
              Pug=3
          }
        */
    }
}
