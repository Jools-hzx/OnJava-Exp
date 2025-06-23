package com.jools.reflection_;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/12 15:19
 * @description: TODO
 */
public class ForNamePetCreator extends Creator {

    private static List<Class<? extends Pet>> types = new ArrayList<>();

    // 基类及其子类的全类名
    private static String[] typeNames = {
            "com.jools.reflection_.Mutt",
            "com.jools.reflection_.Pug",
            "com.jools.reflection_.EgyptianMau",
            "com.jools.reflection_.Manx",
            "com.jools.reflection_.Cymric",
            "com.jools.reflection_.Rat",
            "com.jools.reflection_.Mouse",
            "com.jools.reflection_.Hamster"
    };

    // 返回构建好的 Pet 类及其子类实例的集合
    @Override
    public List<Class<? extends Pet>> types() {
        return types;
    }

    @SuppressWarnings("unchecked")
    private static void loader() {
        try {
            for (String name : typeNames) {
                types.add((Class<? extends Pet>) Class.forName(name));
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    static {
        loader();
    }
}
