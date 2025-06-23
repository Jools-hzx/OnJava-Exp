package com.jools.generic_;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/20 18:37
 * @description: TODO
 */
public class GenericsAndCovariance {

    public static void main(String[] args) {

        // 增加通配符提供了协变性的能力
        List<? extends Fruit> fruitList = List.of(
                new Apple(),
                new Orange(),
                new Fruit()
        );

        // 协变性不允许写入操作；除了 null
//        fruitList.add(new Apple());
//        fruitList.add(new Orange());

        // 协变性允许读取操作; 允许直接返回 Fruit
        fruitList.add(null);    // 合法
        Fruit fruit = fruitList.get(0);
        System.out.println(fruit);
    }
}
