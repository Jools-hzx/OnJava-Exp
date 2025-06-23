package main.java.com.jools.stream_;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/3 14:22
 * @description: TODO
 */
public class WhoCalled {

    static void f() {
        try {
            throw new Exception();
        } catch (Exception e) {
            for (StackTraceElement ste : e.getStackTrace()) {
                System.out.println(ste.getMethodName());
            }
        }
    }

    static void g() {
        f();
    }

    static void h() {
        g();
    }

    public static void main(String[] args) {
        f();
        System.out.println("********");
        g();
        System.out.println("********");
        h();
        /*
         输出:
            f
            main
            ********
            f
            g
            main
            ********
            f
            g
            h
            main
        */
    }
}
