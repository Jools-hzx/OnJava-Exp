package main.java.com.jools.thread_;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/3/23 21:40
 * @description: TODO
 */
public class TestStartTwice {

    public static void main(String[] args) {

        T t = new T();
        Thread thread = new Thread(t);
        thread.start();
        thread.start();

        /*
         输出结果：
            Exception in thread "main" java.lang.IllegalThreadStateException
                at java.base/java.lang.Thread.start(Thread.java:800)
                at main.java.com.jools.thread_.TestStartTwice.main(TestStartTwice.java:16)
            run()
        */
    }
}

class T implements Runnable {
    @Override
    public void run() {
        System.out.println("run()");
    }
}
