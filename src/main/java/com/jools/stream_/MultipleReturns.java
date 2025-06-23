package main.java.com.jools.stream_;

import java.util.stream.IntStream;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/3 15:21
 * @description: TODO
 */
public class MultipleReturns {

    public static void f(int i) {
        System.out.println("Initialization that requires cleanup");

        try {
            System.out.println("Point 1");
            if (i == 1) {
                System.out.println("return");
                return;
            }
            System.out.println("Point 2");
            if (i == 2) {
                System.out.println("return");
                return;
            }
            System.out.println("Point 3");
            if (i == 3) {
                System.out.println("return");
                return;
            }
            System.out.println("End");
        } finally {
            System.out.println("Performing cleanup");
        }
    }

    public static void main(String[] args) {
        IntStream.range(0, 5).forEach(MultipleReturns::f);
        /*
         输出:
            Initialization that requires cleanup
            Point 1
            Point 2
            Point 3
            End
            Performing cleanup
            Initialization that requires cleanup
            Point 1
            return
            Performing cleanup
            Initialization that requires cleanup
            Point 1
            Point 2
            return
            Performing cleanup
            Initialization that requires cleanup
            Point 1
            Point 2
            Point 3
            return
            Performing cleanup
            Initialization that requires cleanup
            Point 1
            Point 2
            Point 3
            End
            Performing cleanup
        */
    }
}
