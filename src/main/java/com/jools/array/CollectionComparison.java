package com.jools.array;

import com.jools.generic_.Suppliers;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/25 16:22
 * @description: TODO
 */
public class CollectionComparison {

    // 数组 和 List 集合都可以通过 int 类型下标访问
    public static void main(String[] args) {

        // 借助数组
        BerylliumSphere[] beryArr = new BerylliumSphere[10];
        for (int i = 0; i < 5; i++) {
            beryArr[i] = new BerylliumSphere();
        }
        System.out.println(Arrays.toString(beryArr));
        System.out.println(beryArr[4]);

        // 借助集合 ArrayList
        ArrayList<BerylliumSphere> sphereList = Suppliers.create(ArrayList::new, BerylliumSphere::new, 5);
        System.out.println(sphereList);
        System.out.println(sphereList.get(4));

        // 基础数据类型数组
        int[] integers = {0, 1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(integers));
        System.out.println(integers[4]);

        ArrayList<Integer> intList = new ArrayList<>(
                Arrays.asList(0, 1, 2, 3, 4, 5, 6)
        );
        System.out.println(intList);
        System.out.println(intList.get(4));

        /*
         执行结果:
            [Sphere 0, Sphere 1, Sphere 2, Sphere 3, Sphere 4, null, null, null, null, null]
            Sphere 4
            [Sphere 5, Sphere 6, Sphere 7, Sphere 8, Sphere 9]
            Sphere 9
            [0, 1, 2, 3, 4, 5]
            4
            [0, 1, 2, 3, 4, 5, 6]
            4
        */
    }
}

class BerylliumSphere {
    private static long counter;
    private final long id = counter++;

    @Override
    public String toString() {
        return "Sphere " + id;
    }
}
