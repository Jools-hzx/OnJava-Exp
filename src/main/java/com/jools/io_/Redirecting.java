package com.jools.io_;

import java.io.*;

/**
 * @author Jools He
 * @date 2025/6/21 17:02
 * @description: TODO
 */
public class Redirecting {

    public static void main(String[] args) throws IOException {
        PrintStream console = System.out;
        try (
                BufferedInputStream in = new BufferedInputStream(
                        new FileInputStream("XXX.java"));

                PrintStream out = new PrintStream(
                        new BufferedOutputStream(
                                new FileOutputStream("Redirecting.txt")))
        ) {
            System.setIn(in);   // 重定向输入
            System.setOut(out); // 重定向输出
            System.setErr(out); // 重定向错误输出
            new BufferedReader(new InputStreamReader(System.in))
                    .lines()
                    .forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            System.setOut(console);
        }
    }
}
