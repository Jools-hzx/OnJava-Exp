package main.java.com.jools.stream_;

import java.util.stream.Stream;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/2 17:30
 * @description: TODO
 */
public class StreamOfStreams {

    public static void main(String[] args) {

        Stream.of(1, 2, 3)
                .map(i -> Stream.of("Gonzo", "Kermit", "Beaker"))
                .map(e -> e.getClass().getName())
                .forEach(System.out::println);
        /*
        输出:
        java.util.stream.ReferencePipeline$Head
        java.util.stream.ReferencePipeline$Head
        java.util.stream.ReferencePipeline$Head
        */
    }
}
