package com.jools.designpattern.strategy.hand;

import com.jools.designpattern.singleton.StaticInnerClassSingleton;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/2/3 16:03
 * @description: TODO
 */
public class Player {

    private String name;
    private Strategy strategy;
    private int winCount;
    private int loseCount;
    private int gameCount;

    public Player(String name, Strategy strategy) {
        this.name = name;
        this.strategy = strategy;
    }

    public String getName() {
        return name;
    }

    //下一次出拳
    public Hand nextHand() {
        return this.strategy.nextHand();
    }

    //获胜
    public void win() {
        strategy.study(true);
        winCount++;
        gameCount++;
    }

    //战败
    public void lose() {
        strategy.study(false);
        loseCount++;
        gameCount++;
    }

    //打平的情况
    public void even() {
        gameCount++;
    }

    @Override
    public String toString() {
        return "Player - [" +
                "name='" + name + '\'' +
                ", strategy=" + strategy.getClass().getSimpleName() +
                ", winCount=" + winCount +
                ", loseCount=" + loseCount +
                ", gameCount=" + gameCount +
                ']';
    }
}

