package main.java.com.jools.exception;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/4 20:55
 * @description: TODO
 */
public class BodyException {
    public static void main(String[] args) {
        try (
                First f = new First();
                Second s = new Second()
        ) {
            System.out.println("In Body");
            Third t = new Third();
            new SecondExcept();
            System.out.println("End of body");
        } catch (CE e) {
            System.out.println("Caught " + e);
        }
        /*
         输出:
            Creating  ->First
            Creating  ->Second
            In Body
            Creating  ->Third
            Creating  ->SecondExcept
            Closing  ->Second
            Closing  ->First
            Caught main.java.com.jools.exception.CE
        */
    }
}

class Third extends Reporter {
}
