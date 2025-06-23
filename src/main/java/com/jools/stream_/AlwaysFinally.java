package main.java.com.jools.stream_;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/3 15:17
 * @description: TODO
 */
public class AlwaysFinally {

    public static void main(String[] args) {
        System.out.println("Entering first try block");
        try {
            System.out.println("Entering second try block");
            try {
                throw new FourException();
            } finally {
                System.out.println("finally in 2nd try block");
            }
        } catch (FourException e) {
            System.out.println("Caught FourException in 1st try block");
        } finally {
            System.out.println("finally in 1st try block");
        }

        /*
         执行结果:
            Entering first try block
            Entering second try block
            finally in 2nd try block
            Caught FourException in 1st try block
            finally in 1st try block
        */
    }
}

class FourException extends Exception {
}