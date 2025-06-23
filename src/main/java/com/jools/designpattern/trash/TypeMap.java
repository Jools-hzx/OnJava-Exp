package com.jools.designpattern.trash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @author Jools He
 * @date 2025/6/23 15:03
 * @description: TODO
 */

public class TypeMap<T> {

    public final Map<Class, List<T>> map = new HashMap<>();

    public void add(T o) {
        Class<?> type = o.getClass();
        map.computeIfAbsent(type,
                k -> new ArrayList<T>()).add(o);
    }

    public Stream<List<T>> values() {
        return map.values().stream();
    }
}

