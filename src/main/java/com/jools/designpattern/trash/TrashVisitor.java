package com.jools.designpattern.trash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Jools He
 * @date 2025/6/23 14:46
 * @description: TODO
 */
class PriceVisitor extends Visitor {

    public PriceVisitor() {
        super("price");
    }

    @Override
    public void visit(Aluminum al) {
        double price = al.weight * al.price();
        show("Aluminum", price);
        alTotal += price;
    }

    @Override
    public void visit(Paper p) {
        double price = p.weight * p.price();
        show("Paper", price);
        pTotal += price;
    }

    @Override
    public void visit(Glass g) {
        double price = g.weight * g.price();
        show("Glass", price);
        gTotal += price;
    }

    @Override
    public void visit(Cardboard c) {
        double price = c.weight * c.price();
        show("Cardboard", price);
        cTotal += price;
    }

    @Override
    void visit(Plastic p) {
        double price = p.weight * p.price();
        show("Plastic", price);
        plTotal += price;
    }
}

class WeightVisitor extends Visitor {
    public WeightVisitor() {
        super("weight");
    }

    @Override
    public void visit(Aluminum al) {
        show("Aluminum", al.weight);
        alTotal += al.weight;
    }

    @Override
    public void visit(Paper p) {
        show("Paper", p.weight);
        pTotal += p.weight;
    }

    @Override
    public void visit(Glass g) {
        show("Glass", g.weight);
        gTotal += g.weight;
    }

    @Override
    public void visit(Cardboard c) {
        show("Cardboard", c.weight);
        cTotal += c.weight;
    }

    @Override
    void visit(Plastic p) {
        show("Plastic", p.weight);
        pTotal += p.weight;
    }
}

public class TrashVisitor {
    public static void main(String[] args) {
        List<Trash> bin = new ArrayList<>();
        ParseTrash.fillBin("com/jools/designpattern/trash".replaceAll("/", "."), bin);

        // 各个具体访问者
        List<Visitor> visitors = Arrays.asList(
                new PriceVisitor(), new WeightVisitor());
        // 遍历总 Bin 内的各个 Trash 对象；调用各个 Visitor 对象的 visit() 方法
        bin.forEach(trash -> visitors.forEach(trash::accept));
        visitors.forEach(Visitor::total);
    }
}
