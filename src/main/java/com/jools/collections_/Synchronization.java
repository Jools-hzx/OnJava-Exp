package com.jools.collections_;

import java.util.*;

/**
 * @author Jools He
 * @date 2025/6/17 15:06
 * @description: TODO
 */
public class Synchronization {

    public static void main(String[] args) {

        Collection<String> c = Collections.synchronizedCollection(new ArrayList<>());

        List<String> list = Collections.synchronizedList(new ArrayList<>());

        Set<String> s = Collections.synchronizedSet(new HashSet<>());

        SortedSet<Object> ss = Collections.synchronizedSortedSet(new TreeSet<>());

        Map<Object, Object> m = Collections.synchronizedMap(new HashMap<>());

        SortedMap<Object, Object> sm = Collections.synchronizedSortedMap(new TreeMap<>());
    }
}
