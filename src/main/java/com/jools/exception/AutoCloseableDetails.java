package main.java.com.jools.exception;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/4 17:25
 * @description: TODO
 */
public class AutoCloseableDetails {

    public static void main(String[] args) throws Exception {
        try (
                First f = new First();
                Second s = new Second()
        ) {
        }
        /*
         输出结果:
            Creating  ->First
            Creating  ->Second
            Closing  ->Second
            Closing  ->First
        */
    }
}

class Reporter implements AutoCloseable {

    private String name = this.getClass().getSimpleName();

    Reporter() {
        System.out.println("Creating  ->" + name);
    }

    @Override
    public void close() {
        System.out.println("Closing  ->" + this.name);
    }
}

class First extends Reporter {
}

class Second extends Reporter {
}

