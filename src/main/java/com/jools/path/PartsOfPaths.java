package com.jools.path;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/7 18:04
 * @description: TODO
 */
public class PartsOfPaths {

    public static void main(String[] args) {
        System.out.println(System.getProperty("os.name"));
        Path p = Paths.get("PartsOfPaths").toAbsolutePath();
        System.out.println("URI:" + p);
        System.out.println("-------- NAME COUNT --------");
        for (int i = 0; i < p.getNameCount(); i++) {
            System.out.println(p.getName(i));
        }
        System.out.println("----------------------------");
        System.out.println("Ends with '.java" + p.endsWith(".java"));
        for (Path pp : p) {
            System.out.print(pp + ": ");
            System.out.print("isStartWith = " + p.startsWith(pp) + " : ");
            System.out.println("isEndWith = " + p.endsWith(pp));
        }
        System.out.println("Start with " + p.getRoot() + " \t " + p.startsWith(p.getRoot()));
    }
}
