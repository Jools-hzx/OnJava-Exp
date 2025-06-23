package main.java.com.jools.stream_;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/3 13:35
 * @description: TODO
 */
public class InheritingExceptions {

    public void f() throws SimpleException {
        System.out.println("Throw an SimpleException from  f()");
        throw new SimpleException();
    }

    public static void main(String[] args) {
        InheritingExceptions sed = new InheritingExceptions();
        try {
            sed.f();    // 输出: Throw an SimpleException from  f()
        } catch (SimpleException e) {
            System.out.println("SimpleException");  // 输出: SimpleException
        }
    }
}

class SimpleException extends Exception {
}