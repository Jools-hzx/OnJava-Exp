package com.jools.generic_;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/22 19:12
 * @description: TODO
 */
public class Apply {

    public static <T, S extends Iterable<T>> void apply(S seq, Method f, Object... args) {
        for (T t : seq) {
            try {
                f.invoke(t, args);
            } catch (IllegalAccessException | InvocationTargetException e) {
                // 异常被转换为 RuntimeException (运行时异常)
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) throws NoSuchMethodException {
        List<Shape> shapes = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            shapes.add(new Shape());
        }
        // 调用 List 集合内所有 Shape 元素
        Apply.apply(shapes, Shape.class.getMethod("rotate"));
        Apply.apply(shapes, Shape.class.getMethod("resize", int.class), 7);

        ArrayList<Shape> squares = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            squares.add(new Square());
        }
        // 调用 List 集合内所有 Square 元素
        Apply.apply(squares, Shape.class.getMethod("rotate"));
        Apply.apply(squares, Shape.class.getMethod("resize", int.class), 5);

        /*
         执行结果:
            Shape{id=0} rotate
            Shape{id=1} rotate
            Shape{id=2} rotate
            Shape{id=0} resize7
            Shape{id=1} resize7
            Shape{id=2} resize7
            Square{id=3} rotate
            Square{id=4} rotate
            Square{id=5} rotate
            Square{id=3} resize5
            Square{id=4} resize5
            Square{id=5} resize5
        */
    }
}

class Shape {

    private static long counter = 0;

    private final long id = counter++;

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "{" +
                "id=" + id +
                '}';
    }

    public void rotate() {
        System.out.println(this + " rotate");
    }

    public void resize(int newSize) {
        System.out.println(this + " resize" + newSize);
    }
}

class Square extends Shape {
}
