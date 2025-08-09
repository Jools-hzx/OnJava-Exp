package com.jools.designpattern.decorator;

/**
 * @author Jools He
 * @date 2025/7/27 19:12
 * @description: TODO
 */
public class Main {
    public static void main(String[] args) {
        Display d1 = new StringDisplay("Hello, World!!");

        // 被边界边框装饰 - 返回被装饰后的 Display (SideBorder 继承实现 Border, Border 也是 Display 子类)
        Display d2 = new SideBorder(d1, '#');
        // 被全边界框再次装饰
        Display d3 = new FullBorder(d2);

        d1.show();
        d2.show();
        d3.show();

        Display d4 = new SideBorder(
                new FullBorder(
                        new FullBorder(
                                new SideBorder(
                                        new FullBorder(
                                                new StringDisplay("你好,世界。")
                                        ), '#'
                                )
                        )
                ),
                '*');
        // 被五重包装
        d4.show();
    }
}
