package com.jools.designpattern.strategy.failback;

import java.io.File;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/2/3 17:55
 * @description: TODO
 */
public class LogContext {

    /**
     * 记录日志的方法，提供给客户端使用
     *
     * @param msg
     */
    public void log(String msg) {
        LogStrategy strategy = new DbLog();
        try {
            strategy.log(msg);
        } catch (Exception e) {
            strategy = new FileLog();
            strategy.log(msg);
        }
    }
}
