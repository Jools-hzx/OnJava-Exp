package com.jools.str;

import java.io.PrintStream;
import java.util.Formatter;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/8 17:16
 * @description: TODO
 */
public class Turtle {

    private String name;
    private Formatter f;

    public Turtle(String name, Formatter f) {
        this.name = name;
        this.f = f;
    }

    public void move(int x, int y) {
        // %s 格式说明符表示这是一个 String 参数。
        f.format("%s The Turtle is at (%d, %d)%n", name, x, y);
    }

    public static void main(String[] args) {
        PrintStream out = System.out;
        Turtle tommy = new Turtle("Tommy", new Formatter(System.out));
        Turtle terry = new Turtle("Terry", new Formatter(out));
        tommy.move(0, 0);
        terry.move(4, 8);
        tommy.move(3, 4);
        terry.move(2, 5);
        tommy.move(3, 3);

        /*
         输出:
            Tommy The Turtle is at (0, 0)
            Terry The Turtle is at (4, 8)
            Tommy The Turtle is at (3, 4)
            Terry The Turtle is at (2, 5)
            Tommy The Turtle is at (3, 3)
         */
    }
}
