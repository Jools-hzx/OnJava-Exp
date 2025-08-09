package com.jools.designpattern.memento;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Jools He
 */
public class Gamer {

    @Getter
    private int money;

    private List<String> fruits = new ArrayList<>();

    private Random rand = new Random();

    private static String[] fruitsname = {
            "苹果", "香蕉", "橘子", "草莓"
    };

    public Gamer(int money) {
        this.money = money;
    }

    public void restoreMemento(Memento memento) {
        this.money = memento.money;
        this.fruits = memento.getFruits();
    }

    @Override
    public String toString() {
        return "[" +
                "money=" + money +
                ", fruits=" + fruits +
                ']';
    }

    // 获得一个水果并且随机保存为好吃的
    private String getFruit() {
        String prefix = "";
        if (rand.nextBoolean()) {
            prefix = "好吃的";
        }
        return prefix + fruitsname[rand.nextInt(fruitsname.length)];
    }

    // 拍摄快照
    public Memento createMemento() {
        Memento memento = new Memento(this.money);
        for (String fruit : fruits) {
            // 仅保留好吃的水果
            if (fruit.startsWith("好吃的")) {
                memento.addFruit(fruit);
            }
        }
        return memento;
    }

    public void bet() {
        int dice = rand.nextInt(6) + 1;
        if (dice == 1) {
            money += 100;
            System.out.println("所持金币增加了。 ");
        } else if (dice == 2) {
            money /= 2;
            System.out.println("所持金币减半了。 ");
        } else if (dice == 6) {
            String f = getFruit();
            System.out.println("获得了水果 (" + f + ")");
            fruits.add(f);
        } else {
            System.out.println("什么都没有发送。");
        }
    }
}
