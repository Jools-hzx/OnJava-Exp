package com.jools.designpattern.trash;

import java.util.ArrayList;

/**
 * @author Jools He
 * @date 2025/6/23 3:34
 * @description: TODO
 */
// A List that only admits the right type:
class TrashBin<T extends Trash> extends ArrayList<T> {

    // 记录所有 Trash 实现类的运行时 Class 对象
    final Class<T> binType;

    TrashBin(Class<T> binType) {
        this.binType = binType;
    }

    @SuppressWarnings("unchecked")
    boolean grab(Trash t) {
        // Compare class types:
        if (t.getClass().equals(binType)) {
            add((T) t); // Downcast to this TrashBin type
            return true; // Trash grabbed
        }
        return false; // Trash not grabbed
    }
}

class TrashBinList<T extends Trash> extends ArrayList<TrashBin<? extends T>> {    // [1]

    @SuppressWarnings("unchecked")
    public TrashBinList(Class<? extends T>... types) {
        for (Class<? extends T> type : types) {
            add(new TrashBin<>(type));
        }
    }

    // 基于该集合存放的元素的运行类型（Trash子类）判断结果
    public boolean sort(T t) {
        for (TrashBin<? extends T> ts : this) {
            if (ts.grab(t)) {
                return true;
            }
        }
        return false; // TrashBin not found for t
    }

    public void sortBin(TrashBin<T> bin) {      // [2]
        for (T trash : bin) {
            if (!sort(trash)) {
                throw new RuntimeException(
                        "Bin not found for " + trash);
            }
        }
    }

    // 展示各个 TrashBin 集合的总价值
    public void show() {
        for (TrashBin<? extends T> tbin : this) {
            String typeName = tbin.binType.getSimpleName();
            TrashValue.sum(tbin, typeName);
        }
    }
}

public class RecycleC {
    public static void main(String[] args) {
        TrashBin<Trash> bin =
                new TrashBin<>(Trash.class);
        ParseTrash.fillBin("com/jools/designpattern/trash".replaceAll("/", "."), bin);

        @SuppressWarnings("unchecked")
        TrashBinList<Trash> trashBins =
                new TrashBinList<>(
                        Aluminum.class, Paper.class, Glass.class,
                        // Add one item:
                        Cardboard.class                       // [3]
                );

        trashBins.sortBin(bin);                   // [4]
        trashBins.show();
        TrashValue.sum(bin, "Trash");
    }
}
