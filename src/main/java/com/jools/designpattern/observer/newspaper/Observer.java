package com.jools.designpattern.observer.newspaper;

public interface Observer {

    /**
     * 被通知的方法
     */
    void update(Subject subject);
}
