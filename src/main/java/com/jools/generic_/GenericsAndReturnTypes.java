package com.jools.generic_;


/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/21 20:42
 * @description: TODO
 */
public class GenericsAndReturnTypes {
    void test(InheritedGetter g){
        InheritedGetter result = g.get();    // 返回自限定类型
        GenericGetter getter = g.get(); // 可以返回基类型
    }
}
interface GenericGetter<T extends GenericGetter<T>> {
    T get();
}
interface InheritedGetter extends GenericGetter<InheritedGetter> {}


