package com.jools.designpattern.adapter;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Jools He
 * @date 2025/7/14 11:43
 * @description: Properties 的 Adapter 组件；
 * 通过继承 Properties 类继承 load() store() setProperty() 和 getProperty() 方法
 *用以适配 FileIO 接口中的各个方法
 */
public class PropertiesFileIO extends Properties implements FileIO {

    @Override
    public void readFromFile(String filename) throws IOException {
        load(new FileInputStream(filename));
    }

    @Override
    public void writeToFile(String filename) throws IOException {
        store(new FileOutputStream(filename), "written by PropertiesFileIO");
    }

    @Override
    public void setValue(String key, String value) {
        setProperty(key, value);
    }

    @Override
    public String getValue(String key) {
        return getProperty(key);
    }
}
