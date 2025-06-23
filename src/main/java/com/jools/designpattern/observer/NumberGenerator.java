package com.jools.designpattern.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/1/18 17:14
 * @description: TODO
 */
public abstract class NumberGenerator {

    //保存 Observer 实例
    private List<Observer> observers = new ArrayList<>();

    //注册 Observer 实例
    public void add(Observer observer) {
        observers.add(observer);
    }

    //删除 Observer 实例
    public void deleteObserver(Observer observer) {
        observers.remove(observer);
    }

    //向 Observer 实例发送通知
    public void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

    //获取数值
    public abstract int getNumber();

    //执行更新并通知
    public abstract void execute();
}
