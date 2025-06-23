package main.java.com.jools.stream_;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/3 14:55
 * @description: TODO
 */
public class BetterNullPointerReports {

    public static void main(String[] args) {
        CC[] cca = {
                new CC(new B(new A(null))),
                new CC(new B(null)),
                new CC(null)
        };

        for (CC cc : cca) {
            try {
                System.out.println(cc.b.a.s);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        /*
         输出:
            null
            java.lang.NullPointerException: Cannot read field "s" because "cc.b.a" is null
            java.lang.NullPointerException: Cannot read field "a" because "cc.b" is null
        */
    }
}

class A {
    String s;
    A(String s) {
        this.s = s;
    }
}

class B {
    A a;
    B(A a) {
        this.a = a;
    }
}

class CC {
    B b;
    CC(B b) {
        this.b = b;
    }
}
