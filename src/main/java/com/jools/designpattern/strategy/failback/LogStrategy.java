package com.jools.designpattern.strategy.failback;

public interface LogStrategy {


    /**
     * 记录日志
     *
     * @param msg 需要记录的日志信息
     */
    void log(String msg);
}
