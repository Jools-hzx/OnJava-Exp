package com.jools.designpattern.trash;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jools He
 * @date 2025/6/23 3:23
 * @description: TODO
 */
public class RecycleB {
    public static void main(String[] args) {
        List<Trash> bin = new ArrayList<>();
        ParseTrash.fillBin("com/jools/designpattern/trash".replaceAll("/", "."), bin);
        Bins bins = new Bins(bin);
        bins.show();
    }
}
