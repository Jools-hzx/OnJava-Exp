package com.jools.generic_;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/19 18:03
 * @description: TODO
 */
public class FactoryConstraint {

    public static void main(String[] args) {
        System.out.println(new Foo2<>(new IntegerFactory()));
        System.out.println(new Foo2<>(new Widget.Factory()));
        System.out.println(new Foo2<>(Fudge::new));

        /*
         输出结果:
            [0, 1, 2, 3, 4]
            [Widget{id=1}, Widget{id=2}, Widget{id=3}, Widget{id=4}, Widget{id=5}]
            [Fudge 1, Fudge 2, Fudge 3, Fudge 4, Fudge 5]
        */
    }
}

class IntegerFactory implements Supplier<Integer> {

    private int i = 0;

    @Override
    public Integer get() {
        return i++;
    }
}

class Widget {

    private int id;

    public Widget(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Widget{" +
                "id=" + id +
                '}';
    }

    public static class Factory implements Supplier<Widget> {

        // 标记 Widget 实例的序号
        private int i = 0;

        @Override
        public Widget get() {
            return new Widget(++i);
        }
    }
}

class Fudge {
    private static int count = 1;

    // 增加序号
    private int n = count++;

    @Override
    public String toString() {
        return "Fudge " + n;
    }
}

// 存储 T 类型的 List 集合
class Foo2<T> {

    private List<T> x = new ArrayList<>();

    Foo2(Supplier<T> factory) {
        // 借助 Supplier 创建五个 T 实例对象放入 x 集合内
        for (int i = 0; i < 5; i++) {
            x.add(factory.get());
        }
    }

    @Override
    public String toString() {
        return x.toString();
    }
}


