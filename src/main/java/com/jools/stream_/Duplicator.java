package main.java.com.jools.stream_;

import lombok.Getter;
import org.junit.Test;

import java.util.stream.Stream;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/2 16:24
 * @description: TODO
 */
public class Duplicator {

    public static void main(String[] args) {
        Stream.generate(() -> "duplicate")
                .limit(3)
                .forEach(System.out::println);
        /*
         输出:
            duplicate
            duplicate
            duplicate
        */
    }

    @Test
    public void testBubbles() {
        Stream.generate(Bubbles::bubbler)
                .limit(5)
                .forEach(System.out::println);

        /*
         输出:
            Bubble{val=0}
            Bubble{val=1}
            Bubble{val=2}
            Bubble{val=3}
            Bubble{val=4}
        */
    }
}

class Bubbles {
    final int i;

    public Bubbles(int i) {
        this.i = i;
    }

    private static int count = 0;

    public static Bubble bubbler() {
        return new Bubble(count++);
    }

    @Override
    public String toString() {
        return "Bubbles{" +
                "i=" + i +
                '}';
    }
}
