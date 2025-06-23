package com.jools.designpattern.trash;

//import com.jools.designpattern.visitor_.Visitor;

import java.util.List;

/**
 * @author Jools He
 * @date 2025/6/23 2:32
 * @description: TODO
 */
public class Aluminum extends Trash implements TypedBinMember {

    public Aluminum(double wt) {
        super(wt);
    }

    @Override
    public double price() {
        return Price.ALUMINUM;
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
