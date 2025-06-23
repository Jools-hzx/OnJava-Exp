package com.jools.designpattern.trash;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jools He
 * @date 2025/6/23 2:39
 * @description: TODO
 */
public class Bins {

    final List<Trash> bin;
    final List<Aluminum> aluminum = new ArrayList<>();
    final List<Paper> paper = new ArrayList<>();
    final List<Glass> glass = new ArrayList<>();
    final List<Cardboard> cardboard = new ArrayList<>();

    public Bins(List<Trash> source) {
        bin = new ArrayList<>(source); // Copy
        bin.forEach(t -> {
            // Use reflection to discover Trash type:
            if (t instanceof Aluminum)
                aluminum.add((Aluminum) t);
            if (t instanceof Paper)
                paper.add((Paper) t);
            if (t instanceof Glass)
                glass.add((Glass) t);
            if (t instanceof Cardboard)
                cardboard.add((Cardboard) t);
        });
    }

    public void show() {
        // 计算各个分类型垃圾总价值
        TrashValue.sum(aluminum, "Aluminum");
        TrashValue.sum(paper, "Paper");
        TrashValue.sum(glass, "Glass");
        TrashValue.sum(cardboard, "Cardboard");
        // 计算所有垃圾总价值
        TrashValue.sum(bin, "Trash");
    }
}
