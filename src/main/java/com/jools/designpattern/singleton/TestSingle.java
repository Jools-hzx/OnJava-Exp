package com.jools.designpattern.singleton;

import org.junit.jupiter.api.Test;

/**
 * @author Jools He
 * @date 2025/6/22 13:52
 * @description: TODO
 */
public class TestSingle {

    public static void main(String[] args) {
        Single<String> ss = new Single<>("hello");
        System.out.println(ss.get());

        try {
            Single<String> ss2 = new Single<>("world");
            System.out.println(ss2.get());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        /*
         输出:
            hello
            Attempt to reassign Single<String>
        */
    }

    @Test
    public void testDoubleSingle() {
        Single<Double> pi = new Single<>(Double.valueOf("3.1415926"));
        Double x = pi.get();
        System.out.println(x);
    }
}
