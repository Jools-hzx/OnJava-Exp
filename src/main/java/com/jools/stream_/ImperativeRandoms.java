package main.java.com.jools.stream_;

import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/3/31 22:53
 * @description: TODO
 */
public class ImperativeRandoms {

    public static void main(String[] args) {

        Random rand = new Random(47);
        SortedSet<Integer> rints = new TreeSet<>();
        while (rints.size() < 7) {
            int r = rand.nextInt(20);
            if (r < 5) {
                continue;
            }
            rints.add(r);
        }
        System.out.println(rints); // 输出: [7, 8, 9, 11, 13, 15, 18]
    }
}
