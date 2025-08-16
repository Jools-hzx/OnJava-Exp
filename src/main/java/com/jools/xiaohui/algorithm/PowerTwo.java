package main.java.com.jools.xiaohui.algorithm;

/**
 * @author Jools He
 */
public class PowerTwo {

    public static void main(String[] args) {
        System.out.println(isPower2(16));
        System.out.println(isPower2(21));
    }


    private static boolean isPower2(int n) {
        return (n & n - 1) == 0;
    }
}
