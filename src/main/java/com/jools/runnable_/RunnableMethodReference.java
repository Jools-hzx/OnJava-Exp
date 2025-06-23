package main.java.com.jools.runnable_;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/3/22 19:26
 * @description: TODO
 */
public class RunnableMethodReference {

    public static void main(String[] args) {
        // 匿名内部类实现 Runnable 接口
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Anonymous inner class");
            }
        }).start(); // 输出 Anonymous inner class

        // Lambda 表达式的简写形式
        new Thread(
                () -> System.out.println("lambda")
        ).start();  // 输出 lambda

        // Go 的匿名内部类实现 Runnable 接口
        new Thread(Go::go).start();     // 输出 Go go()
    }
}

class Go {
    static void go() {
        System.out.println(Go.class.getSimpleName() + " go()");
    }
}
