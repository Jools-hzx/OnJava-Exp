package com.jools.designpattern.strategy.hand;

public interface Strategy {

    Hand nextHand();
    void study(boolean win);
}
