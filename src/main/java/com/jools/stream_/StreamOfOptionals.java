package main.java.com.jools.stream_;

import java.util.Optional;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/3 0:01
 * @description: TODO
 */
public class StreamOfOptionals {

    public static void main(String[] args) {
        Signal.stream()
                .limit(10)
                .forEach(System.out::println);

        System.out.println(" --- ");
        Signal.stream()
                .limit(10)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .forEach(System.out::println);

        /*
         输出:
            Optional[Signal [ (dash) ]]
            Optional[Signal [ (dot) ]]
            Optional[Signal [ (dash) ]]
            Optional.empty
            Optional.empty
            Optional[Signal [ (dash) ]]
            Optional.empty
            Optional[Signal [ (dot) ]]
            Optional[Signal [ (dash) ]]
            Optional[Signal [ (dash) ]]
             ---
            Signal [ (dot) ]
            Signal [ (dot) ]
            Signal [ (dash) ]
            Signal [ (dash) ]
        */
    }
}
