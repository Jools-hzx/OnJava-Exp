package com.jools.collections_;

import cn.hutool.core.lang.tree.Tree;
import com.jools.reflection_.A;
import org.checkerframework.checker.units.qual.K;

import java.util.*;

/**
 * @author Jools He
 * @date 2025/6/17 14:54
 * @description: TODO
 */
public class ReadOnly {

    static Collection<String> data = List.of(
            "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"
    );

    public static void main(String[] args) {
        // 对于 Collection
        Collection<String> c = Collections.unmodifiableCollection(new ArrayList<>(data));

        // 对于 List
        List<String> a = Collections.unmodifiableList(new ArrayList<>(data));

        // 对于 Set
        Set<String> s = Collections.unmodifiableSet(new HashSet<>(data));

        // 对于 Map
        Map<String, String> m = Collections.unmodifiableMap(new HashMap<>());

        // 对于 SortedMap
        SortedMap<String, String> sm = Collections.unmodifiableSortedMap(new TreeMap<>());
    }
}
