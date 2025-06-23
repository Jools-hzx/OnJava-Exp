package com.jools.designpattern.strategy.failback;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/2/3 17:55
 * @description: TODO
 */
public class FileLog extends LogStrategyTemplate {

    @Override
    protected void doLog(String msg) {
        System.out.println("时间:" + msg + " 记录到文件中去");
    }
}
