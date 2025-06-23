package com.jools.generic_;

import org.checkerframework.checker.units.qual.C;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/19 16:25
 * @description: TODO
 */

// 货物
class Product {
    private final int id;
    private String description;
    private double price;

    Product(int id, String description, double price) {
        this.id = id;
        this.description = description;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }

    // 更新商品价格
    public void changePrice(double change) {
        this.price += change;
    }

    // 商品生成器，随机生成商品编号
    public static Supplier<Product> generator = new Supplier<>() {
        private Random rand = new Random(47);

        @Override
        public Product get() {
            return new Product(rand.nextInt(1000),
                    "Test",
                    Math.round(rand.nextDouble() * 1000.0) + 0.99);
        }
    };
}

class Shelf extends ArrayList<Product> {
    public Shelf(int initialCapacity) {
        for (int i = 0; i < initialCapacity; i++) {
            add(Product.generator.get());
        }
    }
}

class Aisle extends ArrayList<Shelf> {
    Aisle(int nShelves, int nProducts) {
        for(int i = 0; i < nShelves; i++) {
            add(new Shelf(nProducts));
        }
    }
}

class CheckoutStand {}

class Office {}

public class Store extends ArrayList<Aisle> {

    private List<CheckoutStand> checkoutStands = new ArrayList<>();

    private Office office = new Office();

    public Store(int nAsiles, int nShelves, int nProducts) {
        for(int i = 0; i < nAsiles; i++) {
            add(new Aisle(nShelves, nProducts));
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        // 拼接整理所有 Product 信息
        for (Aisle A : this) {
            for (Shelf shelf : A) {
                for (Product product : shelf) {
                    result.append(product);
                    result.append("\n");
                }
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Store(5, 4, 3));

        /*
         输出结果:
            Product{id=258, description='Test', price=400.99}
            Product{id=861, description='Test', price=160.99}
            Product{id=868, description='Test', price=417.99}
            Product{id=207, description='Test', price=268.99}
            Product{id=551, description='Test', price=114.99}
            Product{id=278, description='Test', price=804.99}
            Product{id=520, description='Test', price=554.99}
            Product{id=140, description='Test', price=530.99}
            Product{id=704, description='Test', price=250.99}
            Product{id=575, description='Test', price=24.99}
            Product{id=674, description='Test', price=440.99}
            Product{id=826, description='Test', price=484.99}
            Product{id=33, description='Test', price=204.99}
            Product{id=810, description='Test', price=272.99}
            Product{id=138, description='Test', price=766.99}
            Product{id=689, description='Test', price=702.99}
            Product{id=746, description='Test', price=778.99}
            Product{id=368, description='Test', price=593.99}
            Product{id=105, description='Test', price=899.99}
            Product{id=222, description='Test', price=323.99}
            Product{id=257, description='Test', price=290.99}
            Product{id=317, description='Test', price=428.99}
            Product{id=80, description='Test', price=824.99}
            Product{id=899, description='Test', price=49.99}
            Product{id=654, description='Test', price=640.99}
            Product{id=209, description='Test', price=736.99}
            Product{id=903, description='Test', price=322.99}
            Product{id=894, description='Test', price=664.99}
            Product{id=57, description='Test', price=764.99}
            Product{id=8, description='Test', price=334.99}
            Product{id=367, description='Test', price=361.99}
            Product{id=882, description='Test', price=980.99}
            Product{id=299, description='Test', price=551.99}
            Product{id=17, description='Test', price=238.99}
            Product{id=53, description='Test', price=174.99}
            Product{id=994, description='Test', price=460.99}
            Product{id=703, description='Test', price=203.99}
            Product{id=434, description='Test', price=94.99}
            Product{id=332, description='Test', price=375.99}
            Product{id=965, description='Test', price=980.99}
            Product{id=228, description='Test', price=878.99}
            Product{id=677, description='Test', price=396.99}
            Product{id=862, description='Test', price=78.99}
            Product{id=244, description='Test', price=16.99}
            Product{id=42, description='Test', price=647.99}
            Product{id=843, description='Test', price=614.99}
            Product{id=886, description='Test', price=899.99}
            Product{id=615, description='Test', price=814.99}
            Product{id=333, description='Test', price=951.99}
            Product{id=213, description='Test', price=362.99}
            Product{id=669, description='Test', price=707.99}
            Product{id=158, description='Test', price=729.99}
            Product{id=601, description='Test', price=969.99}
            Product{id=851, description='Test', price=392.99}
            Product{id=631, description='Test', price=515.99}
            Product{id=332, description='Test', price=428.99}
            Product{id=971, description='Test', price=307.99}
            Product{id=110, description='Test', price=195.99}
            Product{id=913, description='Test', price=918.99}
            Product{id=830, description='Test', price=227.99}
        */
    }
}
