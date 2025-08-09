package com.jools.designpattern.factory.idcard;

import com.jools.designpattern.factory.framework.Factory;
import com.jools.designpattern.factory.framework.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author Jools He
 * @date 2025/7/25 22:04
 * @description: TODO
 */
public class IDCardFactory extends Factory {

    private List<String> owners = new ArrayList<>();
    private List<String> no = new ArrayList<>();

    @Override
    protected Product createProduct(String owner) {
        return new IDCard(owner, UUID.randomUUID().toString().substring(0, 8));
    }

    @Override
    protected void registerProduct(Product product) {
        // 需要向下转型将拥有者的姓名注册，加入到 owners 中
        owners.add(((IDCard) product).getOwner());
        // 记录编号
        no.add(((IDCard) product).getNo());
    }

    public List<String> getOwners() {
        return owners;
    }

    public List<String> getNo() {
        return no;
    }
}
