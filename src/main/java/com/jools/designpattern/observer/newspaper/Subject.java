package com.jools.designpattern.observer.newspaper;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jools He
 * @desc: 目标对象，作为观察者
 */
public class Subject {

    /***
     * 用来保存注册的观察者对象，也就是报纸的订阅者
     */
    private List<Observer> readers = new ArrayList<>();

    /**
     * 读者需要先向报社订阅注册
     * @param reader
     */
    public void attach(Observer reader) {
        readers.add(reader);
    }

    /**
     * 读者支持取消订阅
     * @param reader
     */
    public void detach(Observer reader) {
        readers.remove(reader);
    }

    /**
     * 当每期报纸印刷出来之后，就要迅速主动的被送到读者的手中
     * 相当于通知读者，让他们知道
     */
    protected void notifyObservers() {
        for (Observer reader : readers) {
            reader.update(this);
        }
    }
}
