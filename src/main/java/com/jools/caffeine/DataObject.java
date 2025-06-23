package com.jools.caffeine;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/1/7 12:17
 * @description: TODO
 */
class DataObject {
    private final String data;

    private static int objectCounter = 0;
    // standard constructors/getters

    public DataObject(String data) {
        this.data = data;
    }

    public static DataObject get(String data) {
        objectCounter++;
        return new DataObject(data);
    }

    public String getData() {
        return data;
    }
}
