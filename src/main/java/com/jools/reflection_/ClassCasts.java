package com.jools.reflection_;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/11 22:25
 * @description: TODO
 */

class Building {}
class House extends Building {}

public class ClassCasts {

    public static void main(String[] args) {
        Building b = new House();
        Class<House> houseType = House.class;
        House h = houseType.cast(b);
        h = (House)b;   // 支持类型转换
    }
}
