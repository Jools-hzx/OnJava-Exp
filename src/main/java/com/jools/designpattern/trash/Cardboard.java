package com.jools.designpattern.trash;

//import com.jools.designpattern.visitor_.Visitor;

import java.util.List;

/**
 * @author Jools He
 * @date 2025/6/23 2:34
 * @description: TODO
 */
public class Cardboard extends Trash implements TypedBinMember {

    public Cardboard(double wt) {
        super(wt);
    }

    @Override
    public double price() {
        return Price.CARDBOARD;
    }

    @Override
    public boolean addToBin(List<TypedBin> tBins) {
        return tBins.stream()
                .anyMatch(tBin -> tBin.add(this));
    }

    // Ignore for now; to be used later:
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
