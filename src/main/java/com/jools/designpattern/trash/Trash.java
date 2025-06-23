package com.jools.designpattern.trash;

//import com.jools.designpattern.visitor_.Visitor;

import org.junit.Ignore;

/**
 * @author Jools He
 * @date 2025/6/23 2:28
 * @description: TODO
 */
public abstract class Trash {

    // 基类含有 weight 和 price 信息
    public final double weight;

    public abstract double price();


    public Trash(double weight) {
        this.weight = weight;
    }


    @Override
    public String toString() {
        return String.format(
                "%s weight: %.2f * price: %.2f = %.2f",
                getClass().getSimpleName(),
                weight, price(), weight * price());
    }

    //     Ignore for now; to be used later:
    public abstract void accept(Visitor v);
}
