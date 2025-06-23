package main.java.com.jools.stream_;

import java.util.stream.Stream;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/2 17:19
 * @description: TODO
 */
public class Numbered {

    final int n;

    Numbered(int n) {
        this.n = n;
    }

    @Override
    public String toString() {
        return "Numbered{" +
                "n=" + n +
                '}';
    }

    public static void main(String[] args) {
        Stream.of(1, 2, 5, 31, 1231)
                .map(Numbered::new)
                .forEach(System.out::println);
    }
}


