package com.jools.enum_;

import java.util.stream.Stream;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/5/1 18:13
 * @description: TODO
 */
public class NormalLiskov {

    public static void main(String[] args) {
        Stream.of(new Worm(), new Giraffe())
                .forEach(lf ->
                        System.out.println(lf.move() + "\n" + lf.react()));
        /*
         输出结果:
            Worm::move()
            Worm::react()
            Giraffe::move()
            Giraffe::react()
        */
    }

}

interface LifeForm {

    String move();

    String react();
}

class Worm implements LifeForm {

    @Override
    public String move() {
        return "Worm::move()";
    }

    @Override
    public String react() {
        return "Worm::react()";
    }
}

class Giraffe implements LifeForm {

    @Override
    public String move() {
        return "Giraffe::move()";
    }

    @Override
    public String react() {
        return "Giraffe::react()";
    }
}
