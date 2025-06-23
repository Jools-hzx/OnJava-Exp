package main.java.com.jools.exception;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/4 21:23
 * @description: TODO
 */

// 基类为 Exception
class Annoyance extends Exception {
}

// 基类为 Annoyance
class Sneeze extends Annoyance {
}


public class Human {

    public static void main(String[] args) {
        try {
            // 捕捉精确的异常类型
            throw new Sneeze();
        } catch (Sneeze s) {
            System.out.println("Caught Sneeze");
        } catch (Annoyance a) {
            System.out.println("Caught Annoyance");
        }

        // 仅有一个捕获，则捕获基类类型
        try {
            throw new Sneeze();
        } catch (Annoyance a) {
            System.out.println("Caught Annoyance");
        }

        /*
         输出:
          Caught Sneeze
          Caught Annoyance
         */
    }
}
