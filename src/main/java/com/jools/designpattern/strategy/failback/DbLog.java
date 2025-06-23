package com.jools.designpattern.strategy.failback;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/2/3 17:54
 * @description: TODO
 */
public class DbLog extends LogStrategyTemplate {

    @Override
    protected void doLog(String msg) {
        //制造错误
        if (msg != null && msg.trim().length() > 5) {
            int a = 5 / 0;
        }
        System.out.println("时间: " + msg + "记录到数据库中");
    }
}
