package com.jools.designpattern.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jools He
 */
public class Memento {

    // 所持金钱
    int money;
    // 获得的水果
    ArrayList<String> fruits;

    public Memento(int money) {
        this.money = money;
        fruits = new ArrayList<>();
    }

    void addFruit(String fruit) {
        fruits.add(fruit);
    }

    // 添加水果
    public int getMoney() {
        return money;
    }

    // 获取当前所持有的水果
    public List<String> getFruits() {
        return (List<String>) fruits.clone();
    }
}
