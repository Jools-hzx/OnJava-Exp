package com.jools.generic_;

import java.util.stream.Stream;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/18 19:20
 * @description: TODO
 */
public class BasicSupplierDemo {

    public static void main(String[] args) {
        // 创建 5 个类型为 CountedObject 的 BasicSupplier
        Stream.generate(BasicSupplier.create(CountedObject.class))
                .limit(5)
                .forEach(System.out::println);

        /*
        CountedObject:id=0
        CountedObject:id=1
        CountedObject:id=2
        CountedObject:id=3
        CountedObject:id=4
        */
    }
}

class CountedObject {
    private static long counter = 0;
    private final long id = counter++;

    // 返回 id
    public long id() {
        return id;
    }

    @Override
    public String toString() {
        return "CountedObject:" +
                "id=" + id;
    }
}
