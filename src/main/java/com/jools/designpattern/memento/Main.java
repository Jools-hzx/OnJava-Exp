package com.jools.designpattern.memento;

/**
 * @author Jools He
 * @desc: 它会重复调用 Gamer 的 bet 方法并且显示 Gamer 所持有的金钱
 */
public class Main {

    public static void main(String[] args) {
        Gamer gamer = new Gamer(100);
        Memento memento = gamer.createMemento();

        for (int i = 0; i < 100; i++) {
            System.out.println("===== " + i);  // 显示掷骰子的次数
            System.out.println(" 当前状态: " + gamer);  // 显示主人公现在的状态

            gamer.bet();    // 进行游戏

            System.out.println(" 所持有金钱为 " + gamer.getMoney() + " 元 ");
            // 决定如何处理 Memento
            if (gamer.getMoney() > memento.money) {
                System.out.println(" 我变富了，保存状态");
                memento = gamer.createMemento();
            } else if (gamer.getMoney() < memento.money / 2) {
                System.out.println(" 我变穷了，需要恢复 ");
                gamer.restoreMemento(memento);
            }

            // 等待一段实际
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
