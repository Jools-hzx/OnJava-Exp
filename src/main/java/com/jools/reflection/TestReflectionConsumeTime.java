package com.jools.reflection;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/1/20 10:54
 * @description: TODO
 */
public class TestReflectionConsumeTime {
    public static long timeDiff(long old) {
        return System.currentTimeMillis() - old;
    }

    public static void main(String args[]) throws Exception {

        long numTrials = (long) Math.pow(10, 7);

        long millis;

        millis = System.currentTimeMillis();

        for (int i = 0; i < numTrials; i++) {
            new B();
        }
        System.out.println("Normal instaniation took: "
                + timeDiff(millis) + "ms");

        millis = System.currentTimeMillis();

        Class<B> c = B.class;

        for (int i = 0; i < numTrials; i++) {
            c.newInstance();
        }

        System.out.println("Reflecting instantiation took:"
                + timeDiff(millis) + "ms");

    }
}

class B {

}
