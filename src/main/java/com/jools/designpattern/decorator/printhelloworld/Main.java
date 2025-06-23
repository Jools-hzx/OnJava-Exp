package com.jools.designpattern.decorator.printhelloworld;

import cn.hutool.core.codec.Base32;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/2/4 10:35
 * @description: TODO
 */
public class Main {

    @Test
    public void testMultiStrs() {

        MultiStringDisplay md = new MultiStringDisplay();
        md.add("Good Morning");
        md.add("Good Afternoon");
        md.add("See you soon!!!");
        md.show();

        System.out.println();
        SideBorder b1 = new SideBorder(md, '*');
        b1.show();

        System.out.println();

        FullBorder b2 = new FullBorder(b1);
        b2.show();

        /*
         输出:
            Good Morning
            Good Afternoon
            See you soon!!!

            *Good Morning   *
            *Good Afternoon *
            *See you soon!!!*

            +-----------------+
            |*Good Morning   *|
            |*Good Afternoon *|
            |*See you soon!!!*|
            +-----------------+
        */
    }

    @Test
    public void showUpDownBound() {

        StringDisplay b1 = new StringDisplay("Hello!! World!!!");    // 基础
        UpDownBorder b2 = new UpDownBorder(b1, '-');     // 添加上下边框
        SideBorder b3 = new SideBorder(b2, '*');                  // 添加侧边框
        FullBorder b4 = new FullBorder(b3);                          // 添加全边框

        b1.show();

        System.out.println();
        b2.show();

        System.out.println();
        b3.show();

        System.out.println();
        b4.show();

        SideBorder b5 = new SideBorder(b3, '|');    // 新增侧边框
        UpDownBorder b6 = new UpDownBorder(b5, '/');    // 新增上下边框

        System.out.println();
        b5.show();

        System.out.println();
        b6.show();

        /*
         输出:
         Hello!! World!!!

        ----------------
        Hello!! World!!!
        ----------------

        *----------------*
        *Hello!! World!!!*
        *----------------*

        +------------------+
        |*----------------*|
        |*Hello!! World!!!*|
        |*----------------*|
        +------------------+

        |*----------------*|
        |*Hello!! World!!!*|
        |*----------------*|

        ////////////////////
        |*----------------*|
        |*Hello!! World!!!*|
        |*----------------*|
        ////////////////////
        */

    }

    public static void main(String[] args) {

        StringDisplay b1 = new StringDisplay("Hello, world.");      // 指定输出内容
        SideBorder b2 = new SideBorder(b1, ' ');                 // 添加左右边框
        FullBorder b3 = new FullBorder(b2);                         // 输出携带上下边框 + 左右边框的
        b1.show();
        b2.show();
        b3.show();

        /*
         输出:
            Hello, world.
             Hello, world.
            +---------------+
            | Hello, world. |
            +---------------+
        */

        // 嵌套实例
        SideBorder b4 = new SideBorder(
                new FullBorder(
                        new FullBorder(
                                new SideBorder(
                                        new FullBorder(
                                                new StringDisplay("Hello! Jools Wakooo!!!")),
                                        '*')
                        )
                ), '/');

        b4.show();

        /*
         输出:
            /+----------------------------+/
            /|+--------------------------+|/
            /||*+----------------------+*||/
            /||*|Hello! Jools Wakooo!!!|*||/
            /||*+----------------------+*||/
            /|+--------------------------+|/
            /+----------------------------+/
        */
    }
}
