package com.jools.io_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Jools He
 * @date 2025/6/21 17:11
 * @description: TODO
 */
public class OSExecute {

    public static void command(String command) throws IOException {
        boolean err = false;

        Process process = new ProcessBuilder(
                command.split(" ")
        ).start();

        try (
                // InputStream 从中读取数据
                BufferedReader results = new BufferedReader(
                        new InputStreamReader(process.getInputStream())
                );

                // 通过调用 getErrorStream 捕获; 如果出现错误则抛出 OSExecuteException 异常
                BufferedReader errors = new BufferedReader(
                        new InputStreamReader(process.getErrorStream())
                )
        ) {
            results.lines()
                    .forEach(System.out::println);

            err = errors.lines()
                    .findAny()
                    .isPresent();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (err) {
            throw new OSExecuteExcption("Errors executing " + command);
        }
    }
}
