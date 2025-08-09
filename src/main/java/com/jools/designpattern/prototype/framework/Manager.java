package com.jools.designpattern.prototype.framework;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jools He
 * @description: 使用 Product 接口来复制实例
 */
public class Manager {

    @Getter
    private Map<String, Product> showCases = new HashMap<>();

    public void register(String name, Product proto) {
        showCases.put(name, proto);
    }

    public Product create(String protoName) {
        Product p = showCases.get(protoName);
        return p.createClone();
    }
}
