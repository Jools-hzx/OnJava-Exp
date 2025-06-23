package com.jools.designpattern.trash;

import java.util.List;
import java.util.Map;

/**
 * @author Jools He
 * @date 2025/6/23 15:07
 * @description: TODO
 */
public class ClassToListOfTrashMap {

    public static void show(Map<Class, List<Trash>> map) {
        map.values().forEach(bin -> {
            String typeName = "Trash";

            // 通过 value 获取到该集合的 Trash 具体运行类型
            if (!bin.isEmpty()) {
                typeName = bin.get(0).getClass().getSimpleName();
            }
            TrashValue.sum(bin, typeName);
        });
    }
}
