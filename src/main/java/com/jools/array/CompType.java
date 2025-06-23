package com.jools.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.SplittableRandom;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/25 20:59
 * @description: TODO
 */
public class CompType implements Comparable<CompType> {

    int i;
    int j;
    public static int count = 1;
    private static SplittableRandom random = new SplittableRandom(47);

    public static CompType get() {
        return new CompType(
                random.nextInt(100),
                random.nextInt(100)
        );
    }

    public CompType(int i, int j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public String toString() {
        String ans = "CompType{" +
                "i=" + i +
                ", j=" + j +
                '}';
        if (count++ % 3 == 0) {
            ans += "\n";
        }
        return ans;
    }

    @Override
    public int compareTo(CompType o) {
        return Integer.compare(i, o.i);
    }

    public static void main(String[] args) {
        CompType[] types = new CompType[12];
        Arrays.setAll(types, element -> get());
        ArrayShow.show("Before sorting:", types);
        Arrays.sort(types, Collections.reverseOrder());
        ArrayShow.show("After sorting DESC:", types);

        /*
         输出结果:
            Before sorting::
            [CompType{i=35, j=37}, CompType{i=41, j=20}, CompType{i=77, j=79}
            , CompType{i=56, j=68}, CompType{i=48, j=93}, CompType{i=70, j=7}
            , CompType{i=0, j=25}, CompType{i=62, j=34}, CompType{i=50, j=82}
            , CompType{i=31, j=67}, CompType{i=66, j=54}, CompType{i=21, j=6}
            ]
            After sorting DESC::
            [CompType{i=77, j=79}, CompType{i=70, j=7}, CompType{i=66, j=54}
            , CompType{i=62, j=34}, CompType{i=56, j=68}, CompType{i=50, j=82}
            , CompType{i=48, j=93}, CompType{i=41, j=20}, CompType{i=35, j=37}
            , CompType{i=31, j=67}, CompType{i=21, j=6}, CompType{i=0, j=25}
            ]
        */
    }
}


