package com.jools.generic_;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/19 15:58
 * @description: TODO
 */
public class CollectionMethodDifferences {

    // 获取这个 Class 类内的所有方法名
    static Set<String> methodSet(Class<?> type) {
        return Arrays.stream(type.getMethods())
                .map(m -> m.getName())
                .collect(Collectors.toCollection(TreeSet::new));
    }

    // 显示这个类的所有实现的接口
    static void interfaces(Class<?> type) {
        System.out.println("Interfaces in " + type.getName() + ": ");
        System.out.println(
                Arrays.stream(type.getInterfaces())
                        .map(Class::getSimpleName)
                        .collect(Collectors.toList())
        );
    }

    // 获取 Object 类的所有方法信息
    static Set<String> object = methodSet(Objects.class);

    static {
        // 增加 clone() 方法
        object.add("clone");
    }

    // 查询子类 superSet 在基类 subset 方法集合的基础上新增的方法 + 接口
    static void difference(Class<?> superset, Class<?> subset) {
        System.out.println(superset.getSimpleName() + " extends " + subset.getSimpleName() + ", adds:");
        Set<String> comp = Sets.difference(methodSet(superset), methodSet(subset));
        comp.removeAll(object); // 忽略所有继承自 Object 的方法
        System.out.println(comp);
        interfaces(superset);
    }

    public static void main(String[] args) {

        System.out.println("Collection:" + methodSet(Collection.class));
        interfaces(Collection.class);
        System.out.println("========== Set & Collection ==========");
        difference(Set.class, Collection.class);
        System.out.println("========== Set & Collection ==========");
        difference(HashSet.class, Set.class);
        System.out.println("========== Set & Collection ==========");
        difference(LinkedHashSet.class, HashSet.class);
        System.out.println("========== Set & Collection ==========");
        difference(TreeSet.class, Set.class);
        System.out.println("========== Set & Collection ==========");
        difference(List.class, Collection.class);
        System.out.println("========== Set & Collection ==========");
        difference(ArrayList.class, List.class);
        System.out.println("========== Set & Collection ==========");
        difference(LinkedList.class, List.class);
        System.out.println("========== Set & Collection ==========");
        difference(Queue.class, Collection.class);
        System.out.println("========== Set & Collection ==========");
        difference(PriorityQueue.class, Queue.class);
        System.out.println("========== Map Methods =============");
        System.out.println("Map:" + methodSet(Map.class));

        System.out.println("========== HashMap & Map ============");
        difference(HashMap.class, Map.class);
        System.out.println("========== LinkedHashMap & HashMap ============");
        difference(LinkedHashMap.class, HashMap.class);
        System.out.println("========== SortedMap & Map ============");
        difference(SortedMap.class, Map.class);
        System.out.println("========== TreeMap & Map ============");
        difference(TreeMap.class, Map.class);
    }
}
