package com.jools.reflection_;

import java.util.stream.Stream;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/11 19:53
 * @description: TODO
 */
public class Shapes {

    public static void main(String[] args) {
        Stream.of(
                new Circle(),
                new Square(),
                new Triangle()
        ).forEach(Shape::draw);
    }
}

abstract class Shape {
    void draw() {
        System.out.println(this + ".draw()");
    }

    @Override
    public abstract String toString();
}

class Circle extends Shape {
    @Override
    public String toString() {
        return "Circle";
    }
}

class Square extends Shape {
    @Override
    public String toString() {
        return "Square";
    }
}

class Triangle extends Shape {
    @Override
    public String toString() {
        return "Triangle";
    }
}
