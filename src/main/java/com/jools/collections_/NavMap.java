package com.jools.collections_;

import java.util.NavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

import static com.jools.collections_.HTMLColors.*;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/5/5 15:59
 * @description: TODO
 */
public class NavMap {

    public static final NavigableMap<Integer, String> COLORS =
            new ConcurrentSkipListMap<>(MAP);

    public static void main(String[] args) {
        show(COLORS.firstEntry());
        border();

        show(COLORS.lastEntry());
        border();

        NavigableMap<Integer, String> toLine = COLORS.headMap(rgb("Lime"), true);
        show(toLine);
        border();

        show(COLORS.ceilingEntry(rgb("DeepSkyBlue") - 1));
        border();

        show(COLORS.floorEntry(rgb("DeepSkyBlue") + 1));
        border();

        show(toLine.descendingMap());
        border();

        show(COLORS.tailMap(rgb("MistyRose"), true));
        border();

        show(COLORS.subMap(
                rgb("Orchid"), true,
                rgb("DarkSalmon"), true
        ));
    }
}
