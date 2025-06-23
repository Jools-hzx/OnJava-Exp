package com.jools.designpattern.command_;

/**
 * @author Jools He
 * @date 2025/6/22 21:56
 * @description: TODO
 */
public class Command {

    public final String msg;

    public Command(String msg) {
        this.msg = msg;
    }
}

class CommandPattern {

    public static void show(Command c) {
        System.out.println(c.msg);
    }

    public static void main(String[] args) {
        show(new Command("Hello"));
        show(new Command("World!!!!"));
    }
}
