package main.java.com.jools.functional_;

import java.util.function.Function;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/3/31 20:17
 * @description: TODO
 */
public class ConsumeFunction {

    static Two consumer(Function<One, Two> oneTwo) {
        return oneTwo.apply(new One());
    }

    public static void main(String[] args) {
        Two consumer = consumer(one -> {
            Two two = new Two();
            System.out.println(two);
            // 输出: main.java.com.jools.functional_.Two@cc34f4d
            return two;
        });
        System.out.println(consumer);
        // 输出: main.java.com.jools.functional_.Two@cc34f4d
    }
}

class One {
}

class Two {
}
