package com.jools.generic_;

import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/18 18:05
 * @description: TODO
 */
public class CoffeeSupplier implements Supplier<Coffee>, Iterable<Coffee> {

    public static void main(String[] args) {

        // 借助 Stream 生成器遍历
        Stream.generate(new CoffeeSupplier())
                .limit(5)
                .forEach(System.out::println);

        // 实现了 Iterable 接口；借助增强 for 循环遍历
        for (Coffee consume : new CoffeeSupplier(5)) {
            System.out.println(consume);
        }

        // 先生成 5 个 Coffee 对象; 之后使用迭代器遍历
        Iterator<Coffee> iterator = new CoffeeSupplier(5).iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        /*
         输出结果:
            Americano 0
            Latte 1
            Americano 2
            Mocha 3
            Mocha 4
            Breve 5
            Americano 6
            Latte 7
            Cappuccino 8
            Cappuccino 9
            Americano 10
            Americano 11
            Mocha 12
            Breve 13
            Breve 14
        */
    }

    private Class<?>[] types = {
            Latte.class, Mocha.class,
            Cappuccino.class, Americano.class, Breve.class
    };

    private static Random rand = new Random(47);

    public CoffeeSupplier() {
    }

    public CoffeeSupplier(int size) {
        this.size = size;
    }

    // 用于迭代，生成器中持有的元素数目
    private int size = 0;

    @Override
    public Coffee get() {
        try {
            return (Coffee) types[rand.nextInt(types.length)]
                    .getDeclaredConstructor()
                    .newInstance();
        } catch (Exception e) {     // 报告运行时错误
            throw new RuntimeException(e);
        }
    }

    // 生成器持有的迭代器
    class CoffeeIterator implements Iterator<Coffee> {
        // 初始化容量为当前生成器内的 size
        int count = size;

        @Override
        public boolean hasNext() {
            return count > 0;
        }

        @Override
        public Coffee next() {
            count--;
            return CoffeeSupplier.this.get();
        }

        @Override
        public void remove() {
            throw new RuntimeException("Unsupported operations!!");
        }
    }

    // 返回一个迭代器对象
    public Iterator<Coffee> iterator() {
        return new CoffeeIterator();
    }
}
