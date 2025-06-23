package main.java.com.jools.exception;

import com.google.errorprone.annotations.Var;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/4 21:02
 * @description: TODO
 */
class CloseException extends Exception { }

class Reporters implements AutoCloseable {
    private String name = this.getClass().getSimpleName();

    Reporters() {
        System.out.println("Creating " + name);
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing " + this.name);
    }
}

class Closer extends Reporters {
    @Override
    public void close() throws Exception {
        super.close();      // 调用父类的 close() 方法
        throw new CloseException(); // 抛出异常
    }
}

public class CloseExceptions {

    public static void main(String[] args) {
        try (
                First f = new First();
                Closer c = new Closer();    // close() 抛出异常
                Second s = new Second();
        ) {
            System.out.println("In body");
        } catch (Exception e) {
            System.out.println("Caught " + e);
        }

        /*
         输出: 先分别创建 First + Closer + Second
            Creating  ->First
            Creating Closer
            Creating  ->Second
            In body
            Closing  ->Second
            Closing Closer
            Closing  ->First
            Caught main.java.com.jools.exception.CloseException
        */
    }
}
