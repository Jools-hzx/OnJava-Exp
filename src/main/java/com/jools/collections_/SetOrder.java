package com.jools.collections_;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/5/5 15:37
 * @description: TODO
 */
public class SetOrder {

    static String[] sets = {
            "java.util.HashSet",
            "java.util.TreeSet",
            "java.util.concurrent.ConcurrentSkipListSet",
            "java.util.LinkedHashSet",
            "java.util.concurrent.CopyOnWriteArraySet",
    };

    static final List<String> RLIST = new ArrayList<>(HTMLColors.LIST);

    static {
        Collections.reverse(RLIST);
    }

    public static void main(String[] args) throws Exception {
        for (String s : sets) {
            System.out.format(
                    "[-> %s <-]\n",
                    s.substring(s.lastIndexOf('.') + 1)
            );
            @SuppressWarnings("unchecked")
            Set<String> set = (Set<String>) Class.forName(s).getConstructor().newInstance();
            set.addAll(RLIST);
            set.stream()
                    .limit(10)
                    .forEach(System.out::println);
            /*
            输出结果:
            [-> HashSet <-]
            MediumOrchid
            PaleGoldenRod
            Sienna
            LightSlateGray
            DarkSeaGreen
            Black
            Gainsboro
            Orange
            LightCoral
            DodgerBlue
            [-> TreeSet <-]
            AliceBlue
            AntiqueWhite
            Aquamarine
            Azure
            Beige
            Bisque
            Black
            BlanchedAlmond
            Blue
            BlueViolet
            [-> ConcurrentSkipListSet <-]
            AliceBlue
            AntiqueWhite
            Aquamarine
            Azure
            Beige
            Bisque
            Black
            BlanchedAlmond
            Blue
            BlueViolet
            [-> LinkedHashSet <-]
            YellowGreen
            Yellow
            WhiteSmoke
            White
            Wheat
            Violet
            Turquoise
            Tomato
            Thistle
            Teal
            [-> CopyOnWriteArraySet <-]
            YellowGreen
            Yellow
            WhiteSmoke
            White
            Wheat
            Violet
            Turquoise
            Tomato
            Thistle
            Teal
            */
        }
    }
}
