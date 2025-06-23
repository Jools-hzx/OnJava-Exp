package com.jools.path;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/7 18:23
 * @description: TODO
 */
public class AddAndSubtractPath {

    static Path base = Paths.get("..", "..", "..")
            .toAbsolutePath()
            .normalize();

    static void show(int id, Path result) {
        if (result.isAbsolute()) {
            System.out.println("[" + id + "] " + result.relativize(result));
        } else {
            System.out.println("[" + id + "] " + result);
        }
        try {
            System.out.println("RealPath: " + result.toRealPath());
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        System.out.println(System.getProperty("os.name"));
        System.out.println(base);
        Path p = Paths.get("D:\\study\\onJava\\onjava-exp\\src\\main\\java\\com\\jools\\path\\AddAndSubtractPath.java").toAbsolutePath();
        show(1, p);         // 输出: RealPath: D:\study\onJava\onjava-exp\src\main\java\com\jools\path\AddAndSubtractPath.java

        Path convoluted = p.getParent()
                .getParent()
                .resolve("strings")
                .resolve("..")
                .resolve(p.getParent()).getFileName();
        show(2, convoluted);
        show(3, convoluted.normalize());
    }
}
