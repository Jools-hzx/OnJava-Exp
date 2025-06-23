package com.jools.generic_;

import java.util.stream.Stream;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/22 19:25
 * @description: TODO
 */
public class ApplyFunctional {

    public static void main(String[] args) {

        Stream.of(
                        Stream.generate(Shape::new).limit(2),
                        Stream.generate(Square::new).limit(2)
                ).flatMap(c -> c) // 扁平化流
                .peek(Shape::rotate)
                .forEach(s -> s.resize(7));
        /*
         执行结果:
            Shape{id=0} rotate
            Shape{id=0} resize7
            Shape{id=1} rotate
            Shape{id=1} resize7
            Square{id=2} rotate
            Square{id=2} resize7
            Square{id=3} rotate
            Square{id=3} resize7
        */
    }
}
