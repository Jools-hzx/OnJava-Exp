package main.java.com.jools.exception;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/4 17:35
 * @description: TODO
 */
public class ConstructorException {

    public static void main(String[] args) {

        try (
                First first = new First();
                SecondExcept s = new SecondExcept();
                Second second = new Second()
        ) {
            System.out.println("In body");
        } catch (CE e) {
            System.out.println("Caught" + e);
        }

        /*
         输出:
            Creating  ->First
            Creating  ->SecondExcept
            Closing  ->First
            Caughtmain.java.com.jools.exception.CE      // SecondExept 的 close() 方法 没有 被带哦用
        */
    }
}

// 自定义 CE 异常
class CE extends Exception {
}

class SecondExcept extends Reporter {
    public SecondExcept() throws CE {
        super();
        // 构造器抛出异常
        throw new CE();
    }
}