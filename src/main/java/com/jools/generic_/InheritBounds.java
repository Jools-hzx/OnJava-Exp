package com.jools.generic_;

import java.awt.*;
import java.util.ArrayList;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/19 20:11
 * @description: TODO
 */

class HoldItem<T> {

    T item;

    HoldItem(T item) {
        this.item = item;
    }

    T getItem() {
        return item;
    }
}

// 继承 HoldItem, 复用 item
class WithColor2<T extends HasColor> extends HoldItem<T> {

    WithColor2(T item) {
        super(item);
    }

    Color color() {
        // 直接访问继承 HoldItem 中的 item; 不需要在自己维护一个 item 字段
        return item.getColor();
    }
}

// 继承 WithColor, 复用 color()
class WithColorCoords2<T extends Coord & HasColor> extends WithColor2<T> {

    WithColorCoords2(T item) {
        super(item);
    }

    int getX() {
        return item.x;
    }

    int getY() {
        return item.y;
    }

    int getZ() {
        return item.z;
    }
}

// 继承 WithColorCoords2 复用 getX、getY、getZ
class Solid2<T extends Coord & HasColor & Weight> extends WithColorCoords2<T> {
    Solid2(T item) {
        super(item);
    }

    int weight() {
        return item.weight();
    }
}

public class InheritBounds {

    public static void main(String[] args) {
        // 通过
        Solid2<Bounded> solid2 = new Solid2<>(new Bounded());
        solid2.color();
        solid2.getY();
        solid2.weight();

        String ans = String.join(" ", new ArrayList<>());

    }
}
