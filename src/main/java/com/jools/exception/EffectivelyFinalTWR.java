package main.java.com.jools.exception;

import java.io.*;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/4 21:15
 * @description: TODO
 */
public class EffectivelyFinalTWR {

    public static void main(String[] args) {
        try {
            EffectivelyFinalTWR.old();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    static void old() throws IOException {
        final InputStream r1 = new FileInputStream("CleanupIdiom.java");
        final FileInputStream r2 = new FileInputStream("CleanupIdiom.java");
        try (r1; r2) {
            r1.read();
            r2.read();
        }
        // r1 和 r2 都在作用域中
        // 访问其中的任何一个都会抛出异常
        r1.read();
        r2.read();
    }
}
