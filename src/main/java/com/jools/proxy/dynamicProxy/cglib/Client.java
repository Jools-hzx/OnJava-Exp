package com.jools.proxy.dynamicProxy.cglib;



/**
 * @author Jools He
 * @version 1.0
 * @date 2025/1/19 23:46
 * @description: TODO
 */
public class Client {

    public static void main(String[] args) {

        SlowRunServiceImpl serviceImpl = new SlowRunServiceImpl();
        serviceImpl.run("Jools Wakoo");

        SlowRunServiceImpl proxy = ((SlowRunServiceImpl) CglibProxyFactory.getProxy(SlowRunServiceImpl.class));
        proxy.run("Jools Wakooooooo");

        /*
        输出:
            慢跑中.....	Jools Wakoo
            Before Method: 准备锻炼...... 	 run
            慢跑中.....	Jools Wakooooooo
            After Method: 结束锻炼.... 	run
         */
    }
}
