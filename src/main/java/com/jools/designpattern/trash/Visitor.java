package com.jools.designpattern.trash;

/**
 * @author Jools He
 * @date 2025/6/23 14:33
 * @description: TODO
 */

public abstract class Visitor {

    // 计算 Aluminum 的总价值
    protected double alTotal; // Aluminum

    // 计算 Paper 的总价值
    protected double pTotal;  // Paper

    // 计算 Glass 的总价值
    protected double gTotal;  // Glass

    // 计算 Cardboard 的总价值
    protected double cTotal;  // Cardboard

    // 计算 Plastic 的总价值
    protected double plTotal; // Plastic

    protected String descriptor;

    protected Visitor(String descriptor) {
        this.descriptor = descriptor;
    }

    protected void show(String type, double value) {
        System.out.printf(
                "%s %s: %.2f%n", type, descriptor, value);
    }

    public void total() {
        show("Total Aluminum", alTotal);
        show("Total Paper", pTotal);
        show("Total Glass", gTotal);
        show("Total Cardboard", cTotal);
    }

    abstract void visit(Aluminum a);

    abstract void visit(Paper p);

    abstract void visit(Glass g);

    abstract void visit(Cardboard c);

    abstract void visit(Plastic p);
}
