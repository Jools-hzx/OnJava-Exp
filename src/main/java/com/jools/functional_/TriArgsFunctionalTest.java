package main.java.com.jools.functional_;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/3/31 19:47
 * @description: TODO
 */
public class TriArgsFunctionalTest {

    static int f(int i, long l, double d) {
        return 99;
    }

    public static void main(String[] args) {
        TriFunction<Integer, Long, Double, Integer> tf = TriArgsFunctionalTest::f;
        System.out.println(tf.apply(1, 2L, 3.0));
        tf = (i, l, d) -> 111;
        System.out.println(tf.apply(1, 2L, 3.0));
    }
}
