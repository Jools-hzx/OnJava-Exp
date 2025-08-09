package com.jools.designpattern.flyweight.template;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jools He
 * @date 2025/7/29 21:21
 * @description: TODO
 */
public class FlyweightFactory {

    /*
     缓存多个 Flyweight 对象
    */
    private Map<String, Flyweight> fsMap = new HashMap<>();

    public Flyweight getFlyweight(String key) {
        // 1. 先从缓存里面查找,是否存在 key 对应的 flyweight
        // 2. 如果存在，就返回相应的 Flyweight 对象并且加入 fsMap
        return fsMap.computeIfAbsent(key, ConcreteFlyweight::new);
    }
}
