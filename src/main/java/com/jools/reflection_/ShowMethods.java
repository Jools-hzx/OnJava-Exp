package com.jools.reflection_;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/12 19:24
 * @description: TODO
 */
public class ShowMethods {

    private static String usage = "usage:\n" +
            "ShowMethods qualified.class.name\n"
            + "To show all methods in class or:\n"
            + "ShowMethods qualified.class.name word\n"
            + "To search for methods involving 'word'";

    private static Pattern p = Pattern.compile("\\w+\\.");

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println(usage);
            System.exit(0);
        }
        int line = 0;
        try {
            Class<?> cls = Class.forName(args[0]);
            Method[] methods = cls.getDeclaredMethods();
            Constructor<?>[] constors = cls.getConstructors();
            if (args.length == 1) {
                for (Method method : methods) {
                    System.out.println(
                            p.matcher(method.toString()));
                }
                for (Constructor<?> ctor : constors) {
                    p.matcher(ctor.toString()).replaceAll("");
                }
                line = methods.length + constors.length;
            } else {
                for (Method m : methods) {
                    if (m.toString().contains(args[1])) {
                        System.out.println(p.matcher(m.toString()).replaceAll(""));
                        line++;
                    }
                }
                for (Constructor<?> ctor : constors) {
                    if (ctor.toString().contains(args[1])) {
                        System.out.println(p.matcher(ctor.toString()).replaceAll(""));
                        line++;
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            System.out.println("No such class: " + e);
        }
    }
}
