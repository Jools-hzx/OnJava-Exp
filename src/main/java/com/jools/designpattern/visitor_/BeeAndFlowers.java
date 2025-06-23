package com.jools.designpattern.visitor_;

import java.util.Arrays;
import java.util.List;
import java.util.SplittableRandom;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class BeeAndFlowers {

    public static void main(String[] args) {
        List<Flower> flowers = Stream.generate(FlowerFactory::newFlower)
                .limit(10)
                .toList();
        StringVal stringVal = new StringVal();

        // Flower 会根据此时的运行类型动态绑定到运行类型重写的 accept 方法
        // accept 方法支持 Visitor 具体实现类 (StringVal)
        flowers.forEach(f -> {
            f.accept(stringVal);
            System.out.println(stringVal);
        });

        // accept 方法支持 Visitor 具体实现类 (Bee)
        Bee bee = new Bee();
        flowers.forEach(f -> f.accept(bee));

        /*
         输出结果:
            StringVal{s='Ranunculus'}
            StringVal{s='Ranunculus'}
            StringVal{s='Ranunculus'}
            StringVal{s='Gladiolus'}
            StringVal{s='Ranunculus'}
            StringVal{s='Chrysanthemum'}
            StringVal{s='Gladiolus'}
            StringVal{s='Chrysanthemum'}
            StringVal{s='Ranunculus'}
            StringVal{s='Chrysanthemum'}
            Bee and Ranunculus
            Bee and Ranunculus
            Bee and Ranunculus
            Bee and Gladiolus
            Bee and Ranunculus
            Bee and Chrysanthemum
            Bee and Gladiolus
            Bee and Chrysanthemum
            Bee and Ranunculus
            Bee and Chrysanthemum
        */
    }
}

interface Visitor {

    void visit(Gladiolus g);

    void visit(Ranunculus r);

    void visit(Chrysanthemum c);
}

// Flower 的层次结构无法被更改
interface Flower {
    void accept(Visitor v);
}

class Gladiolus implements Flower {
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}

class Ranunculus implements Flower {

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}

class Chrysanthemum implements Flower {
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}

// 增加生成字符串能力
class StringVal implements Visitor {

    private String s;

    @Override
    public String toString() {
        return "StringVal{" +
                "s='" + s + '\'' +
                '}';
    }

    @Override
    public void visit(Gladiolus g) {
        s = "Gladiolus";
    }

    @Override
    public void visit(Ranunculus r) {
        s = "Ranunculus";
    }

    @Override
    public void visit(Chrysanthemum c) {
        s = "Chrysanthemum";
    }
}

// 增加 Bee 各种行为
class Bee implements Visitor {

    @Override
    public void visit(Gladiolus g) {
        System.out.println("Bee and Gladiolus");
    }

    @Override
    public void visit(Ranunculus r) {
        System.out.println("Bee and Ranunculus");
    }

    @Override
    public void visit(Chrysanthemum c) {
        System.out.println("Bee and Chrysanthemum");
    }
}

// 随机获取 Flower
class FlowerFactory {

    static List<Supplier<Flower>> flowers = Arrays.asList(
            Ranunculus::new, Gladiolus::new, Chrysanthemum::new
    );

    static final int SZ = flowers.size();

    private static SplittableRandom rand = new SplittableRandom();

    public static Flower newFlower() {
        return flowers.get(rand.nextInt(SZ)).get();
    }
}


