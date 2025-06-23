package com.jools.reflection_;

import java.util.HashMap;
import java.util.stream.Collectors;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/12 17:09
 * @description: 对某一类实现计数 (更具通用性)
 */
public class TypeCounter extends HashMap<Class<?>, Integer> {

    private Class<?> baseType;

    public TypeCounter(Class<?> baseType) {
        this.baseType = baseType;
    }

    // 计数，Object 当前实例的数目
    public void count(Object obj) {
        Class<?> cls = obj.getClass();
        if (!baseType.isAssignableFrom(cls)) {
            throw new RuntimeException(
                    obj + " incorrect type: " + cls +
                            ", should be type or subtype of " + baseType);
        }
        countClass(cls);
    }

    private void countClass(Class<?> cls) {
        Integer quantity = get(cls);
        put(cls, quantity == null ? 1 : quantity + 1);  // 更新该类的计数
        Class<?> superCls = cls.getSuperclass();
        if (superCls != null && baseType.isAssignableFrom(superCls)) {
            countClass(superCls);  // 递归调用, 更新基类计数
        }
    }

    @Override
    public String toString() {
        String result = entrySet().stream().map(
                pair -> String.format(
                        "%s=%s",
                        pair.getKey().getSimpleName(),
                        pair.getValue()
                )).collect(Collectors.joining(", "));
        return "{" + result + "}";
    }
}
