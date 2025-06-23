package com.jools.designpattern.decorator.printhelloworld;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/2/4 13:04
 * @description: TODO
 */
public class MultiStringDisplay extends Display {

    private List<String> strs;

    public MultiStringDisplay() {
        this.strs = new ArrayList<>();
    }

    public void add(String s) {
        this.strs.add(s);
    }

    @Override
    public int getColumns() {
        int maxSize = Integer.MIN_VALUE;
        for (String str : strs) {
            maxSize = Math.max(str.length(), maxSize);
        }
        return maxSize;
    }

    @Override
    public int getRows() {
        return this.strs.size();
    }

    @Override
    public String getRowText(int row) {
        int size = getColumns();
        String str = strs.get(row);
        return str + " ".repeat(Math.max(0, size - str.length())); //
    }
}
