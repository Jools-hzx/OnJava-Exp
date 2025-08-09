package com.jools.designpattern.facade;

import java.util.Properties;

/**
 * @author Jools He
 * @date 2025/7/28 22:52
 * @description: TODO
 */
public class DataBase {

    private DataBase() {}

    public static Properties getProperties(String dbname) {
        Properties props = new Properties();
        props.put("jools666@qq.com", "jools");
        return props;
    }
}
