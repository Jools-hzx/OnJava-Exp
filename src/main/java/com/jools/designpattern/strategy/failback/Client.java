package com.jools.designpattern.strategy.failback;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/2/3 17:56
 * @description: TODO
 */
public class Client {

    public static void main(String[] args) {

        LogContext log = new LogContext();
        log.log("记录日志");
        log.log("再次记录日志");

        /*
         输出:
            时间:2025-02-03 19:33:16 内容是：记录日志 记录到文件中去
            时间:2025-02-03 19:33:16 内容是：再次记录日志 记录到文件中去
        */
    }
}
