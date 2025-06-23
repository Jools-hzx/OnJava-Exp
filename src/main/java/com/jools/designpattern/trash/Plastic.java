package com.jools.designpattern.trash;

import java.util.List;

/**
 * @author Jools He
 * @date 2025/6/23 15:34
 * @description: TODO
 */
public class Plastic extends Trash implements TypedBinMember {

    public Plastic(double weight) {
        super(weight);
    }

    @Override
    public double price() {
        return Price.PLASTIC;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    @Override
    public boolean addToBin(List<TypedBin> tBins) {
        return tBins.stream()
                .anyMatch(tBin -> tBin.add(this));
    }
}
