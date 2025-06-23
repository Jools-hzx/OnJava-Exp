package com.jools.generic_;

import java.awt.*;
import java.util.List;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/20 19:29
 * @description: TODO
 */
public class SuperTypeWildcards {

    static void writeTo(List<? super Apple> apples) {
        apples.add(new Apple());
        apples.add(new Jonathan());
//        apples.add(new Frame()); 报错
    }
}
