package com.jools.designpattern.factory;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @author Jools He
 * @date 2025/6/22 17:30
 * @description: TODO
 */
public class FactoryMethodTest {

    public static void test(FactoryMethod factory) {
        Stream.of("Circle", "Square", "Triangle",
                        "Circle", "Square", "Triangle")
                .map(factory::create)
                .forEach(Shape::draw);
    }

    public static void main(String[] args) {
        // 借助实现抽象工厂方法的匿名内部类
        test(type -> {
            switch (type) {
                case "Circle" -> {
                    return new Circle();
                }
                case "Square" -> {
                    return new Square();
                }
                case "Triangle" -> {
                    return new Triangle();
                }
                default -> throw new IllegalArgumentException("Unknown type: " + type);
            }
        });
    }
}

// 多态工厂方法
interface PolymorphicFactory {
    Shape create();
}

class RandomShapes implements Supplier<Shape> {

    private final PolymorphicFactory[] factories;

    private Random rand = new Random(42);

    public RandomShapes(PolymorphicFactory... factories) {
        this.factories = factories;
    }

    // 实现: 随机获取一个工厂对象, 并调用其 create() 方法
    @Override
    public Shape get() {
        return factories[rand.nextInt(factories.length)].create();
    }

    public static void main(String[] args) {
        RandomShapes rs = new RandomShapes(
                Circle::new, Square::new, Triangle::new
        );
        Stream.generate(rs)
                .limit(6)
                .peek(Shape::draw)
                .peek(Shape::erase)
                .count();

        /*
         输出:
            Triangle[id: 0] draw
            Triangle[id: 0] erase
            Circle[id: 1] draw
            Circle[id: 1] erase
            Circle[id: 2] draw
            Circle[id: 2] erase
            Triangle[id: 3] draw
            Triangle[id: 3] erase
            Circle[id: 4] draw
            Circle[id: 4] erase
            Square[id: 5] draw
            Square[id: 5] erase
        */
    }
}


// 动态工厂方法
class DynamicFactory implements FactoryMethod {

    private Map<String, Constructor<?>> factories = new HashMap<>();

    // 基于具体形状的类型获取构造器
    private static Constructor<?> load(String t) {
        try {
            // 拼接得到全类名
            return Class.forName("com.package.name." + t).getConstructor();
        } catch (Exception e) {
            throw new BadShapeCreation(e);
        }
    }

    @Override
    public Shape create(String type) {
        try {
            return (Shape) factories.computeIfAbsent(type, DynamicFactory::load)
                    .newInstance();
        } catch (Exception e) {
            throw new BadShapeCreation(e);
        }
    }

    public static void main(String[] args) {
        FactoryMethodTest.test(new DynamicFactory());
    }
}

class ShapeFactory implements FactoryMethod {

    @Override
    public Shape create(String type) {
        switch (type) {
            case "Circle" -> {
                return new Circle();
            }
            case "Square" -> {
                return new Square();
            }
            case "Triangle" -> {
                return new Triangle();
            }
            default -> throw new IllegalArgumentException("Unknown type: " + type);
        }
    }

    public static void main(String[] args) {
        FactoryMethodTest.test(new ShapeFactory());
    }
}

interface FactoryMethod {

    /**
     * 创建对象方法
     *
     * @return 具体 Shape
     */
    Shape create(String type);
}


// 具体形状类
class Circle extends Shape {
}

class Square extends Shape {
}

class Triangle extends Shape {
}

class Shape {

    private static int counter = 0;
    private int id = counter++;

    @Override
    public String toString() {
        return getClass().getSimpleName() + "[id: " + id + "]";
    }

    public void draw() {
        System.out.println(this + " draw");
    }

    public void erase() {
        System.out.println(this + " erase");
    }
}
