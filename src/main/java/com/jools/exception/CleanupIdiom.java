package main.java.com.jools.exception;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/3 16:48
 * @description: TODO
 */
public class CleanupIdiom {

    public static void main(String[] args) {

        // [1]:
        NeedCleanup nc1 = new NeedCleanup();
        try {
            ///....
        } finally {
            // 释放构造成功的 nc1
            nc1.dispose();
        }

        // [2]"
        // 如果构造不会失败，一并释放
        NeedCleanup nc2 = new NeedCleanup();
        NeedCleanup nc3 = new NeedCleanup();
        try {
            //....
        } finally {
            nc3.dispose();
            nc2.dispose();
        }

        try {   // 捕获 nc4 构造失败
            NeedCleanup2 nc4 = new NeedCleanup2();
            try {   // 捕获 nc5 构造失败
                NeedCleanup2 nc5 = new NeedCleanup2();
                try {   // 捕获执行异常
                    //....
                } finally {
                    // nc5 构造成功，确保释放
                    nc5.dispose();
                }
            } catch (ConstructionException e) {
                // nc5 构造失败
                System.out.println(e);
            } finally {
                // nc4 构造成功，确保释放
                nc4.dispose();
            }
        } catch (ConstructionException e) {
            System.out.println(e);
        }

        /*
         输出：
            NeedsCleanup1 is disposed!!!
            NeedsCleanup3 is disposed!!!
            NeedsCleanup2 is disposed!!!
            NeedsCleanup5 is disposed!!!
            NeedsCleanup4 is disposed!!!
        */
    }
}


class NeedCleanup {
    private static long counter = 1;
    private final long id = counter++;

    public void dispose() {
        System.out.println("NeedsCleanup" + id + " is disposed!!!");
    }
}

class ConstructionException extends Exception {
}

class NeedCleanup2 extends NeedCleanup {
    // 构造可能失败
    NeedCleanup2() throws ConstructionException {
    }
}
