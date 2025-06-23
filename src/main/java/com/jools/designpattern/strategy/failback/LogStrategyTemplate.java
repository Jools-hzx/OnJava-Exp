package com.jools.designpattern.strategy.failback;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/2/3 19:26
 * @description: TODO
 */
public abstract class LogStrategyTemplate implements LogStrategy {

    @Override
    public final void log(String msg) {
        // 第一步: 给消息添加记录日志的时间
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
        msg = df.format(new Date()) + " 内容是：" + msg;
        // 第二步: 真正执行日志记录
        doLog(msg);
    }

    // 真正执行日志记录，让子类去具体实现
    protected abstract void doLog(String msg);
}
