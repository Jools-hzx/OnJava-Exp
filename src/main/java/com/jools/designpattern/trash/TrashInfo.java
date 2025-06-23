package com.jools.designpattern.trash;

/**
 * @author Jools He
 * @date 2025/6/23 2:57
 * @description: TODO
 */
public class TrashInfo {
    public final String type;
    public final double data;

    public TrashInfo(String type, double data) {
        this.type = type;
        this.data = data;
    }

    @Override
    public String toString() {
        return "TrashInfo(" + type + ", " + data + ")";
    }
}
