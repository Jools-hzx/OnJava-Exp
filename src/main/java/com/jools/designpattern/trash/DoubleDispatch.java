package com.jools.designpattern.trash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Jools He
 * @date 2025/6/23 14:03
 * @description: TODO
 */

/*
 各种 Trash 子类的对应的收集 TypedBin
*/
class AluminumBin extends TypedBin {
    public AluminumBin() {
        super("Aluminum");
    }

    @Override
    public boolean add(Aluminum a) {
        return addIt(a);
    }
}

class PaperBin extends TypedBin {
    public PaperBin() {
        super("Paper");
    }

    @Override
    public boolean add(Paper a) {
        return addIt(a);
    }
}

class GlassBin extends TypedBin {
    public GlassBin() {
        super("Glass");
    }

    @Override
    public boolean add(Glass a) {
        return addIt(a);
    }
}

class CardboardBin extends TypedBin {
    public CardboardBin() {
        super("Cardboard");
    }

    @Override
    public boolean add(Cardboard a) {
        return addIt(a);
    }
}

class PlasticBin extends TypedBin {
    public PlasticBin() {
        super("Plastic");
    }

    @Override
    public boolean add(Plastic a) {
        return addIt(a);
    }
}

/**
 * 各个 Trash 类型的 Bin 集合
 */
class TrashBinSet {

    public final List<TypedBin> binSet =
            Arrays.asList(
                    new AluminumBin(), new PaperBin(),
                    new GlassBin(), new CardboardBin(),
                    new PlasticBin()
            );

    @SuppressWarnings("unchecked")
    public void sortIntoBins(List bin) {
        bin.forEach(aBin -> {
            TypedBinMember t = (TypedBinMember) aBin;
            if (!t.addToBin(binSet))    // 动态绑定类型匹配
                throw new RuntimeException(
                        "sortIntoBins() couldn't add " + t);
        });
    }
}

public class DoubleDispatch {

    public static void main(String[] args) {
        // 1. 解析文件 - 生成垃圾到总 bin
        List<Trash> bin = new ArrayList<>();
        ParseTrash.fillBin("com/jools/designpattern/trash".replaceAll("/", "."), bin);

        // 2. 将垃圾收集到各个类型的 typebin 中
        TrashBinSet bins = new TrashBinSet();
        bins.sortIntoBins(bin);                     // 动态绑定各个 Trash 类型到指定 TypedBin
        bins.binSet.forEach(tb ->          // 计算各个 TypedBin 内 Trash Value
                TrashValue.sum(tb.bin(), tb.type)); // 基于当前 Trash 类型 和 TypedBin 内各个元素

        // 3. 计算总 Bin 内的总 Trash Value
        TrashValue.sum(bin, "Trash");
    }
}
