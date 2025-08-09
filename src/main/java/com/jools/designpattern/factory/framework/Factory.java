package com.jools.designpattern.factory.framework;

import java.util.UUID;

/**
 * @author Jools He
 * @date 2025/7/25 21:56
 * @description: TODO
 */
public abstract class Factory {

    // 使用模板方法，用于生成产品
    public final Product create(String owner) {
        Product p = createProduct(owner);
        registerProduct(p);
        return p;
    }

    // 用于注册产品
    protected abstract Product createProduct(String owner);

    // 用于注册产品
    protected abstract void registerProduct(Product product);
}
