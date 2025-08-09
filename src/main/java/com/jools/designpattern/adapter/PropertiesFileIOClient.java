package com.jools.designpattern.adapter;

import java.io.IOException;

/**
 * @author Jools He
 * @date 2025/7/14 11:47
 * @description: TODO
 */
public class PropertiesFileIOClient {
    public static void main(String[] args) {

        PropertiesFileIO f = new PropertiesFileIO();
        try {
            f.readFromFile("src/main/java/com/jools/designpattern/adapter/target.txt");
            f.setValue("year", "2025");
            f.setValue("month", "7");
            f.setValue("day", "14");
            f.writeToFile("src/main/java/com/jools/designpattern/adapter/target.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
