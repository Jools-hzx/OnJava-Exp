package com.jools.designpattern.command_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Jools He
 * @date 2025/6/22 21:59
 * @description: TODO
 */
public class Macro {
    public static void main(String[] args) {
        // 宏定义
        List<Runnable> MACROS = new ArrayList<>(
                Arrays.asList(
                        () -> System.out.println("Hello "),
                        () -> System.out.println("World!!!"))
        );

        // 遍历
        MACROS.forEach(Runnable::run);

        // 添加方便
        MACROS.add(
                () -> System.out.println("I'm the command pattern!!!")
        );

        MACROS.forEach(Runnable::run);
    }
}
