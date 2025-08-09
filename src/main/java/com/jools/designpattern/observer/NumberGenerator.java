package com.jools.designpattern.observer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Jools He
 * @date 2025/7/29 11:26
 * @description: TODO
 */
public abstract class NumberGenerator {

    private List<Observer> observers = new ArrayList<>();

    public void add(Observer observer) {
        observers.add(observer);
    }

    public void deleteObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        Iterator<Observer> iter = observers.iterator();
        while (iter.hasNext()) {
            Observer next = iter.next();
            next.update(this);
        }
    }

    // 获取数值
    public abstract int getNumber();

    // 生成数值
    public abstract void execute();
}
